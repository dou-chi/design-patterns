package com.fn2xn.dp.singleton;

/**
 * @description: 双检测实现
 * @author: Lee
 * @time: 2020/8/29 22:56
 */
public class DoubleCheckSingleton {

    /**
     * volatile 保持线程可见性，防止【指令重排】
     *
     */
    private static volatile DoubleCheckSingleton instance;

    /**
     * 构造私有化
     */
    private DoubleCheckSingleton(){}

    public static DoubleCheckSingleton getInstance(){
        if (instance == null){
            synchronized (DoubleCheckSingleton.class){
                if (instance == null){
                    instance = new DoubleCheckSingleton();
                }
            }
        }
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
