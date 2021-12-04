package threadcoreknowledge.stopthreads;

/**
 * 描述：
 * 判断线程中断状态的相关方法：
 * 1、static boolean interrupted() //返回当前线程的状态，并且清除当前线程的中断状态
 * 2、boolean isInterrupted()//返回当前线程的状态，不会清除线程的中断状态
 * 这里注意1中interrupted()方法的目标对象是“当前线程”，而不管本方法来自于哪个对象！
 */
public class RightWayInterrupted {

    public static void main(String[] args) throws InterruptedException {

        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                for (; ; ) {
                }
            }
        });

        // 启动线程
        threadOne.start();
        //设置中断标志
        threadOne.interrupt();
        //获取中断标志
        System.out.println("isInterrupted: " + threadOne.isInterrupted()); //true
        //获取中断标志并重置
        System.out.println("isInterrupted: " + threadOne.interrupted());//true，（当前线程）是main线程，这里是返回main的状态并且将其中断状态清除
        //获取中断标志并重直
        System.out.println("isInterrupted: " + Thread.interrupted());//false,  （当前线程）main函数的状态，因为上面清除了main的状态所以这里返回false
        //获取中断标志
        //true，threadOne在第二步threadOne.interrupt()中被设置中断后只isInterrupted查询了一次状态再没有改变过状态
        System.out.println("isInterrupted: " + threadOne.isInterrupted());
        threadOne.join();
        System.out.println("Main thread is over.");
    }
}
