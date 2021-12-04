package threadcoreknowledge.startthread;

import threadcoreknowledge.createthreads.ThreadStyle;

/**
 * 描述：     对比start和run两种启动线程的方式
 */
public class StartAndRunMethod {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName());

        };
        runnable.run(); //这里只是调用了run方法，并没有创建线程因此输出的线程名还是main

        new Thread(runnable).start();
    }
}
