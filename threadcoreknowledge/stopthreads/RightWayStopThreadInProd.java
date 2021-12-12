package threadcoreknowledge.stopthreads;

import threadcoreknowledge.createthreads.ThreadStyle;

/**
 * 描述：     最佳实践：catch了InterruptedExcetion之后的优先选择：在方法签名中抛出异常 那么在run()就会强制try/catch
 */
public class RightWayStopThreadInProd implements Runnable {

    @Override
    public void run() {
//        !Thread.currentThread().isInterrupted()如果有sleep方法，还是会清除，因此这个判断没用
        while (true && !Thread.currentThread().isInterrupted()) {
            System.out.println("正常的业务逻辑处理....");
            try {
                //调用别人的方法
                throwInMethod();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                //保存日志、停止程序
                System.out.println("保存日志");
                e.printStackTrace();
            }
        }
    }

    //1、可以throw出去，而不是直接try,catch吞掉
    private void throwInMethod() throws InterruptedException {
            Thread.sleep(2000); //会清除当前线程中断的标记位（吞掉）
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadInProd());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
