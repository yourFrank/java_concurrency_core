package threadcoreknowledge.stopthreads;

/**
 * 1、当sleep在while循环的外面的情况
 * 描述：     带有sleep的中断线程的写法
 */
public class RightWayStopThreadWithSleep {

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            int num = 0;
            try {
                //此时while循环中需要进行!Thread.currentThread().isInterrupted()判断，因为大部分时间都是在while循环中的，当被其他线程终止时就需要停止循环了
                while (num <= 300 && !Thread.currentThread().isInterrupted()) {
                    if (num % 100 == 0) {
                        System.out.println(num + "是100的倍数");
                    }
                    num++;
                }
                Thread.sleep(1000);//在sleep时被中断的话，sleep响应中断的方式就是抛出异常
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(500);
        thread.interrupt();
    }
}
