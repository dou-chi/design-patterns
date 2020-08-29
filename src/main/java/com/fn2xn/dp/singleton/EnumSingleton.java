package com.fn2xn.dp.singleton;

/**
 * @description: 枚举实现单例模式
 * @author: Lee
 * @time: 2020/8/29 23:31
 */
public enum EnumSingleton {

    INSTANCE;

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t  " + EnumSingleton.INSTANCE.hashCode());
            },"线程：" + i).start();

        }
    }
}
