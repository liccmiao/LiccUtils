package licc.utils.example.concurrency;

import java.util.Iterator;
import java.util.TimerTask;

import org.apache.log4j.Logger;

public class LinkedBlockingQueueInsert extends TimerTask {

    private Logger log = Logger.getLogger(LinkedBlockingQueueInsert.class);

    private int insertTotalNum;
    private int insertNum;

    @Override
    public void run() {
        try {
            //try throw NPE
            checkIterator();
            //checkIterator2();

            for (int i = 0; i < insertNum; ++i) {
                LinkedBlockingQueueSyncTest.getInstance().offer("test");
                insertTotalNum++;
            }
        } catch (Throwable e) {
            log.info("failed:", e);
        }
    }

    public LinkedBlockingQueueInsert(int num) {
        insertNum = num;
        insertTotalNum = 0;
    }

    //throw NPE ?
    private void checkIterator() {
        LinkedBlockingQueueSyncTest testLbq = LinkedBlockingQueueSyncTest.getInstance();
        for (Iterator<String> itr = testLbq.iterator(); itr.hasNext(); ) {
            //			if (insertTotalNum != 0 && insertTotalNum % 10000 == 0)
            if (testLbq.size() == 0 && itr.hasNext() == true)
                log.info("checking itr: lbq.size[" + testLbq.size() + "], itr.hasNext[" + itr.hasNext() + "]");
            String element = itr.next();
            element.equals("!test"); //NPE here, element == null sometimes
        }

    }

//    private void checkIterator2() {
//        LinkedBlockingQueue<String> q = licc.utils.example.concurrency.LinkedBlockingQueueSyncProxy.getInstance().getLbq();
//        List<String> l = new ArrayList<String>();
//        synchronized (q) {
//            l.addAll(q);
//        }
//        for (Iterator<String> itr = l.iterator(); itr.hasNext(); ) {
//            String element = itr.next();
//            element.equals("!test");
//        }
//    }

}
