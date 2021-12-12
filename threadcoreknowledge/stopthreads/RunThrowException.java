package threadcoreknowledge.stopthreads;

/**
 * 描述：     run无法抛出checked Exception，只能用try/catch
 */
public class RunThrowException {

    public void aVoid() throws Exception {
        throw new Exception();
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run()  {
                try {
                    throw new Exception(); //比如这里出现了异常，只能try/catch，不能throw了
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
