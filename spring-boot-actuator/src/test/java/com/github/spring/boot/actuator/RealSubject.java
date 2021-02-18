package com.github.spring.boot.actuator;

/**
 * TODO
 * <p>
 * create in 2021/2/10 12:52 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

public class RealSubject implements Subject {

    @Override
    public void doSomething() {
        System.out.println("RealSubject do something");
    }

}

