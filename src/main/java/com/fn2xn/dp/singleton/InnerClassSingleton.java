package com.fn2xn.dp.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * @description:内部静态类实现单例模式
 * @author: Lee
 * @time: 2020/8/29 23:23
 */
public class InnerClassSingleton implements Serializable {

    private static final long serialVersionUID = -6317719715110713627L;

    private InnerClassSingleton(){};

    public static InnerClassSingleton getInstance(){
        return instanceHolder.instance;
    }

    /**
     * 定义静态内部类持有单例对象属性
     * JVM 类加载机制，当静态内部类使用到时，才会去初始化
     *
     */
    private static class instanceHolder{

        private static InnerClassSingleton instance = new InnerClassSingleton();

    }

    /**
     * 提供反序列化方法，使反序列化后对象与原来一样
     * @return Object
     * @throws ObjectStreamException
     */
    private Object readResolve() throws ObjectStreamException {
        return instanceHolder.instance;
    }



    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t  " + getInstance());
            },"线程：" + i).start();

        }
    }
}
