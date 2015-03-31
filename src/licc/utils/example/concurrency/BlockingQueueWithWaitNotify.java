package licc.utils.example.concurrency;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Created by mengchenli on 2015/3/31.
 */
public class BlockingQueueWithWaitNotify<T> {
    private Queue<T> q = new LinkedList<T>();
    private int capacity;

    public BlockingQueueWithWaitNotify(int c) {
        capacity = c;
    }

    public synchronized void put(T t) throws InterruptedException {
        while (q.size() == capacity) {
            this.wait();
        }

        q.add(t);
        this.notify();
    }

    public synchronized T take() throws InterruptedException {
        while (q.size() == 0) {
            this.wait();
        }

        T ret = q.remove();
        this.notify();
        return ret;
    }
}
