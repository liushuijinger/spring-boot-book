package com.shuijing.boot.ioc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author 刘水镜
 * @blog https://liushuijinger.blog.csdn.net
 * @date 2021-06-14
 */

public class IocTests {

    private Container container;


    @BeforeEach
    public void init() {
        container = new Container();
        container.put(Bike.class,new Bike());
        container.put(Car.class,new Car());
        container.put(Train.class,new Train());
        container.put(AirPlane.class,new AirPlane());
        container.put(Ship.class,new Ship());
    }

    @Test
    public void test() {
        Driveable bike = container.getBean(Bike.class);
        Person xiaoMing = new Person(bike);
        xiaoMing.hangOut();

        Driveable car = container.getBean(Car.class);
        xiaoMing = new Person(car);
        xiaoMing.hangOut();

        Driveable train = container.getBean(Train.class);
        xiaoMing = new Person(train);
        xiaoMing.hangOut();

        Driveable airPlane = container.getBean(AirPlane.class);
        xiaoMing = new Person(airPlane);
        xiaoMing.hangOut();

        Driveable ship = container.getBean(Ship.class);
        xiaoMing = new Person(ship);
        xiaoMing.hangOut();
    }
}
