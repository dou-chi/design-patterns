package com.fn2xn.dp.singleton;

/**
 * @description: 饿汉式单例加载
 * @author: Lee
 * @time: 2020/8/29 23:19
 */
public class HungrySingleton {

    /**
     * 类初始化时就加载到内存中
     */
    private static HungrySingleton instance = new HungrySingleton();

    private HungrySingleton(){

    }

    public static HungrySingleton getInstance(){
        return instance;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t  " + getInstance());
            },"线程：" + i).start();

        }
    }


}
