package synchronized_practice;

public class ShowSafe implements Runnable{

    static ShowSafe r=new ShowSafe();
    static int i=0;
    @Override
    public synchronized void run() {
            for (int j = 0; j < 100000; j++) {
                i+=1;
            }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(r);
        Thread t2=new Thread(r);
        t1.start();
        t2.start();
        t1.join();//join可以让t1方法执行完毕后再运行下面的
        t2.join();
        System.out.println(i);

    }
}
