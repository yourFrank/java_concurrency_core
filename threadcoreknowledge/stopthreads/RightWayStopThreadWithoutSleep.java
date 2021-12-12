package threadcoreknowledge.stopthreads;

/**
 * 描述：  1、线程不阻塞：   run方法内没有sleep或wait方法时，如何停止线程？
 */
public class RightWayStopThreadWithoutSleep implements Runnable {

    @Override
    public void run() {
        int num = 0;
        //!Thread.currentThread().isInterrupted() 普通的情况下，应该加入这句来进行判断线程终止状态看是否停止线程
        while (!Thread.currentThread().isInterrupted() && num <= Integer.MAX_VALUE / 2) {
            if (num % 10000 == 0) {
                System.out.println(num + "是10000的倍数");
            }
            num++;
        }
        System.out.println("任务运行结束了");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadWithoutSleep());
        thread.start();
        Thread.sleep(1000);//让main线程等1秒，此时RightWayStopThreadWithoutSleep线程还在继续跑
        thread.interrupt();//两秒后此时请求RightWayStopThreadWithoutSleep中断
    }
}
