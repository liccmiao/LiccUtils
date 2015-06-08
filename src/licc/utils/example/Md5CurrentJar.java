package licc.utils.example;

import java.io.*;
import java.math.BigInteger;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;

/**
 * Created by mengchenli on 2015/3/3.
 */
public class Md5CurrentJar {
    private static Logger log = Logger.getLogger(Md5CurrentJar.class.getName());

    public static void main(String[] args) {
        try {
            jarMD5();
        } catch (IOException e) {
            log.warning(e.getMessage());
        }
    }

    public static String getMd5(String input) {

        String md5 = null;
        if (null == input) return null;
        try {
            //Create MessageDigest object for MD5
            MessageDigest digest = MessageDigest.getInstance("MD5");
            //Converts message digest value in base 16 (hex)
            md5 = new BigInteger(1, digest.digest(input.getBytes("UTF-8"))).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return md5;
    }

    public static String md5File(File f, int byteArraySize)
            throws NoSuchAlgorithmException, IOException {

        MessageDigest md = MessageDigest.getInstance("MD5");
        md.reset();
        byte[] bytes = new byte[byteArraySize];

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(f);
            int numBytes;
            while ((numBytes = fis.read(bytes)) != -1) {
                md.update(bytes, 0, numBytes);
            }
            fis.close();
            fis = null;
        } catch (IOException e) {
            log.warning(e.getMessage());
            throw e;
        } finally {
            if (fis != null)
                fis.close();
        }
        byte[] digest = md.digest();
        return new BigInteger(1, digest).toString(16);
    }

    public static void jarMD5() throws IOException {

        try {
            String jarPath = Md5CurrentJar.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
            String decodedPath = URLDecoder.decode(jarPath, "UTF-8");
            File file = new File(decodedPath);
            log.info("file: " + file.getAbsolutePath());
            log.info("MD5 in hex: " + md5File(file, 2048));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
