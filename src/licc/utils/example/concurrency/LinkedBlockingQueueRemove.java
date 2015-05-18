package licc.utils.example.concurrency;

import java.util.TimerTask;

public class LinkedBlockingQueueRemove extends TimerTask {

    private int removeTotalNum;
    private int removeNumEachTurn;

    public LinkedBlockingQueueRemove(int rmvNum) {
        removeNumEachTurn = rmvNum;
        removeTotalNum = 0;
    }

    @Override
    public void run() {

        System.out.println("Removing... lbq.size = " + LinkedBlockingQueueSyncTest.getInstance().size());

        try {

            if (removeTotalNum != 0 && removeTotalNum % 10 == 0) {
                //each 10 times, poll all element
                while (LinkedBlockingQueueSyncTest.getInstance().poll() != null)
                    removeTotalNum++;

            } else {

                for (int i = 0; i < removeNumEachTurn; ++i) {
                    LinkedBlockingQueueSyncTest.getInstance().poll();
                    removeTotalNum++;
                }
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }

    }

}
