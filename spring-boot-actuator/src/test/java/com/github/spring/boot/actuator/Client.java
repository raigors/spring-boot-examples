package com.github.spring.boot.actuator;

/**
 * TODO
 * <p>
 * create in 2021/2/10 12:54 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

public class Client {
    public static void main(String[] args) {
        // 保存生成的代理类的字节码文件
//        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        // jdk动态代理测试
        Subject subject = new JDKDynamicProxy(new RealSubject()).getProxy();
        subject.doSomething();
    }
}
