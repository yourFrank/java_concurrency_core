package threadcoreknowledge.stopthreads;

/**
 * 描述：     如果while里面放try/catch，会导致中断失效
 */
public class CantInterrupt {

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            int num = 0;
            //2、这时在while这里进行下一次循环时!Thread.currentThread().isInterrupted()进行判断状态
            //3、但是发现线程还是没有中断，原因:一旦Thread.sleep（）响应中断，则会将线程的终止状态进行清除。所以这里判断为true没被中断，还会进行循环
            //那么该如何处理这种情况呢？ 可看prod和prod2，生产环境中如何正确处理sleep产生的异常
            while (num <= 10000 && !Thread.currentThread().isInterrupted()) {
                if (num % 100 == 0) {
                    System.out.println(num + "是100的倍数");
                }
                num++;
                //如果try，catch放在这里的话
                try {
                    Thread.sleep(10); //如果终止的话在这里就抛出异常
                } catch (InterruptedException e) {
                    e.printStackTrace(); //1、这里抛出异常后被catch住了，此时下一次循环还会执行。
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(5000);
        thread.interrupt();
    }
}
