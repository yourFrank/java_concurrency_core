package synchronized_practice;

/**
 * 类锁的第一种形式，static形式
 */
public class SynchronizedClassStatic4 implements Runnable{
    private static SynchronizedClassStatic4 instant1 = new SynchronizedClassStatic4();
    private static SynchronizedClassStatic4 instant2 = new SynchronizedClassStatic4();

    @Override
    public void run() {
        method();
    }
    private static synchronized void method() {
        System.out.println("我是对象锁的方法形式，我叫" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);//休眠3秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 运行结束");
    }

    //下面和之前一样创建两个线程
    public static void main(String[] args) {
        Thread t1 = new Thread(instant1);
        Thread t2 = new Thread(instant2);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()) {//换一种方式这里如果存活一直循环，也就是等t1或者t2执行完再执行后面的
        }
        System.out.println("finished ");
    }

}
