package licc.utils.example.io.net;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by mengchenli on 2015/5/4.
 */
public class URLExampleTest {

    Logger log = Logger.getLogger(URLExampleTest.class);

    @Test
    public void testUrlExample() {
        try {
            URL url = new URL("http://www.bing.com/");
            URLConnection conn = url.openConnection();
            InputStream in = conn.getInputStream();
            BufferedReader bdr = new BufferedReader(new InputStreamReader(in));
            String line;
            while ((line = bdr.readLine()) != null) {
                System.out.println(line);
            }

        } catch (MalformedURLException e) {
            log.warn("Invalid URL [http://www.bing.com/]", e);
        } catch (IOException e) {
            log.warn(e.getMessage());
        }

    }


}
