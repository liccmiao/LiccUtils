package licc.utils.example.concurrency;

import java.util.Iterator;
import java.util.Timer;
import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockingQueueSyncTest {

    private LinkedBlockingQueue<String> tQueue;
    private static final int QUEUE_CAPACITY = 1000;
    private static LinkedBlockingQueueSyncTest instance = null;

    private LinkedBlockingQueueSyncTest() {
        tQueue = new LinkedBlockingQueue<>(QUEUE_CAPACITY);
    }

    public static synchronized LinkedBlockingQueueSyncTest getInstance() {
        if (instance == null)
            instance = new LinkedBlockingQueueSyncTest();
        return instance;
    }

    public boolean offer(String s) {
        return tQueue.offer(s);
    }

    public String poll() {
        return tQueue.poll();
    }

    public int size() {
        return tQueue.size();
    }

    public Iterator<String> iterator() {
        return tQueue.iterator();
    }

    /**
     */
    public static void main(String[] args) {
        //default
        int insertNumEachTurn = 1;
        int insertFrequency = 10; //10ms insert 1
        int removeNumEachTurn = 120;
        int removeFrequency = 1000; //1s remove 120

        Timer insertTimer = new Timer();
        insertTimer.scheduleAtFixedRate(new LinkedBlockingQueueInsert(insertNumEachTurn), 0, insertFrequency);

        Timer removeTimer = new Timer();
        removeTimer.scheduleAtFixedRate(new LinkedBlockingQueueRemove(removeNumEachTurn), 0, removeFrequency);

    }

//    public LinkedBlockingQueue<String> getLbq() {
//        return tQueue;
//    }

}
