package com.lover.model;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "it_publish_relation")
public class ItPublishRelation {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    @ApiModelProperty(value = "用户id")
    private Long userId;

    /**
     * 发布信息id
     */
    @Column(name = "publish_id")
    @ApiModelProperty(value = "发布信息id")
    private Long publishId;

    /**
     * 备注（其他）
     */
    @ApiModelProperty(value = "备注（其他）")
    private String remark;

    /**
     * 状态 1：待审核 2：审核通过 3：配对成功 4：作废
     */
    @ApiModelProperty(value = "状态 1：待审核 2：审核通过 3：配对成功 4：作废")
    private Integer status;
}
