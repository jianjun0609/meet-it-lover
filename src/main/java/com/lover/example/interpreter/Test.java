package com.lover.example.interpreter;

import com.lover.example.mediator.Colleague;
import com.lover.example.mediator.ColleagueLandlord;
import com.lover.example.mediator.ConcreteMediator;

/**
 * @author Jack
 * @date 2020/7/3 11:06
 */
public class Test {

    public static void main(String[] args) {
        // 定义房客同事类
        Colleague colleagueTenant = new ColleagueLandlord();
        // 定义房东同事类
        Colleague colleagueLandLord = new ColleagueLandlord();
        // 创建一个具体的中间者，这里可以将其理解为房屋中介
        ConcreteMediator concreteMediator = new ConcreteMediator(colleagueTenant, colleagueLandLord);
        boolean resoult = concreteMediator.notifyColleagueTenant("想租2室一厅的吗");
        if (resoult) {
            concreteMediator.notifyColleagueLandlord("租客对面积满意");
        } else {
            concreteMediator.notifyColleagueLandlord("租客对面积不满意");
        }
    }

}
