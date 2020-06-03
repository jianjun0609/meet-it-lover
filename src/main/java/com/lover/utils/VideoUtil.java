package com.lover.utils;

import ws.schild.jave.MultimediaInfo;
import ws.schild.jave.MultimediaObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.channels.FileChannel;

/**
 * @author zengyou
 * @Description:  视频时长，大小 工具类
 * @date 2019/2/15 11:19
 */
public class VideoUtil {

    /**
     * * 
     * * @描述：获取视频时长 单位 s (秒)
     * * @时间：2018年8月28日 上午10:18:59
     * * @param source
     * * @return
     *     
     */
    public static Long  ReadVideoTime(File source) {
        Long length = null;
        try {
            MultimediaObject instance = new MultimediaObject(source);
            MultimediaInfo result = instance.getInfo();
            long ls = result.getDuration() / 1000;
           /* int hour = (int) (ls / 3600);
            int minute = (int) (ls % 3600) / 60;
            int second = (int) (ls - hour * 3600 - minute * 60);
            length = hour + "'" + minute + "''" + second + "'''";*/
            length = ls;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return length;
    }

    /**
     * * 
     * * @描述：获取视频大小 单位 MB (兆)
     * * @时间：2018年8月28日 上午10:30:17
     * * @param source
     * * @return
     *     
     */
    public static BigDecimal ReadVideoSize(File source) {
        FileChannel fc = null;
        BigDecimal size = null;
        try {
            FileInputStream fis = new FileInputStream(source);
            fc = fis.getChannel();
            BigDecimal fileSize = new BigDecimal(fc.size());
            size = fileSize.divide(new BigDecimal(1048576), 2, RoundingMode.HALF_UP);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != fc) {
                try {
                    fc.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return size;
    }

}
