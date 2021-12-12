package threadcoreknowledge.createthreads;

/**
 * 描述：     同时使用Runnable和Thread两种实现线程的方式
 */

public class BothRunnableThread {
        //这里使用匿名子类（继承父类，可以覆写父类的方法），传入Runnable接口的同时重写了Thread的run方法
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("我来自Runnable");
            }
        }) {
            @Override
            public void run() {
                System.out.println("我来自Thread");
            }
        }.start();
    }
}
