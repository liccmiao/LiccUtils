package licc.utils.example;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by mengchenli on 2015/5/4.
 */

public class PropertiesExample {

    private static Properties prop = null;
    private static PropertiesExample pe = null;
    private String propertyFile = "file/proptest.properties";
    private Logger log = Logger.getLogger(PropertiesExample.class);

    private PropertiesExample() {
        if (prop == null)
            prop = new Properties();
    }

    public static PropertiesExample getInstance() {
        if (pe == null)
            pe = new PropertiesExample();
        return pe;
    }

    public void load(String filename) {
        FileInputStream in = null;
        try {
            in = new FileInputStream(filename);
            prop.load(in);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            log.error("Load Property file [" + filename + "]", e);
        } finally {
            try {
                if (in != null)
                    in.close();
            } catch (IOException e) {
                log.warn("Close FileInputStream Fail ", e);
            }
        }
    }

    public void save() {
        save(propertyFile);
    }

    public void save(String filename) {
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(filename);
            prop.store(out, "--- No Comments ---");
        } catch (IOException e) {
            log.error("Save Property file [" + filename + "]", e);
        } finally {
            try {
                if (out != null)
                    out.close();
            } catch (IOException e) {
                log.warn("Close FileOutputStream Fail", e);
            }
        }

    }


    public boolean contains(String value) {
        return prop.contains(value);
    }

    public boolean containsKey(String key) {
        return prop.containsKey(key);
    }

    public String getProperty(String key) {
        return prop.getProperty(key);
    }

    public int size() {
        return prop.size();
    }

    public Object setProperty(String key, String value) {
        return prop.setProperty(key, value);
    }

    public Object removeProperty(String key) {
        return prop.remove(key);
    }

    public String getPropertyFile() {
        return propertyFile;
    }

    public void setPropertyFile(String fn) {
        propertyFile = fn;
    }
}