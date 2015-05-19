package licc.utils.example.concurrency;

/**
 * Created by mengchenli on 2015/5/19.
 */
public class PrintCountThreadWaitNotify implements Runnable {

    public static enum STATE {
        A, B, C;

        public STATE next() {
            if (this == A)
                return B;
            else if (this == B)
                return C;
            else
                return A;
        }
    }

    private static Object lock = new Object();
    private static STATE s = STATE.A;
    private STATE waitState;
    private static final int PRINT_NUM = 10;
    private int count;
    private String name;

    public PrintCountThreadWaitNotify(String name, STATE wS) {
        this.name = name;
        this.waitState = wS;
    }

    @Override
    public void run() {
        while (count < PRINT_NUM) {
            synchronized (lock) {
                while (s != waitState) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Thread: " + name + ", " + count);
                s = s.next();
                lock.notifyAll();
            }
            count++;
        }

    }


    public static void main(String[] args) {
        new Thread(new PrintCountThreadWaitNotify("A", STATE.A)).start();
        new Thread(new PrintCountThreadWaitNotify("B", STATE.B)).start();
        new Thread(new PrintCountThreadWaitNotify("C", STATE.C)).start();
    }
}

