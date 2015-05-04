package licc.utils.example.concurrency;

import org.junit.Test;

import java.io.*;

/**
 * Created by mengchenli on 2015/5/4.
 */

public class ProcessStartExampleTest {

    @Test
    public void testProcessStartExample() {
        String startPingCmd = "C:\\Program Files\\Vim\\vim73\\gvim.exe";

        try {
            Process p = Runtime.getRuntime().exec(startPingCmd);
            Thread.sleep(1000);
            p.destroy();
            System.out.println(p.waitFor());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}