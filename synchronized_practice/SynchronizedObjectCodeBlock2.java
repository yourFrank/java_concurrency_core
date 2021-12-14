package synchronized_practice;

/**
 * 对象锁实例1，代码块
 */
public class SynchronizedObjectCodeBlock2 implements Runnable {
    private static SynchronizedObjectCodeBlock2 instant = new SynchronizedObjectCodeBlock2();
    Object lock1 = new Object();
    Object lock2 = new Object();

    @Override
    public void run() {
        synchronized (lock1) {
            System.out.println("我是lock1对象锁的代码块形式，我叫" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);//休眠3秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 运行结束");
        }
        synchronized (lock2) {
            System.out.println("我是lock2对象锁的代码块形式，我叫" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);//休眠3秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 运行结束");
        }

    }


    public static void main(String[] args) {
        Thread t1 = new Thread(instant);
        Thread t2 = new Thread(instant);
        t1.start();
        t2.start();
//        t1.join();
//        t2.join();
        while (t1.isAlive() || t2.isAlive()) {//换一种方式这里如果存活一直循环，也就是等t1或者t2执行完再执行后面的
        }
        System.out.println("finished ");
    }
}
