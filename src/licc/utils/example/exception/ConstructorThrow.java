package licc.utils.example.exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by mengchenli on 2015/4/16.
 * <p/>
 * This is a bad example, the correct way is to catch the exception and handle necessary jobs,
 * such as reset the jobs that have been completed.
 * from : http://www.programcreek.com/2013/01/constructor-can-throw-exceptions-in-java/
 */
public class ConstructorThrow {
    public static boolean flag = false;

    public ConstructorThrow() throws IOException {
        flag = true;
        File dir = new File(".");
        File fin = new File(dir.getCanonicalPath() + File.separator + "not-exist-file");
        FileInputStream fis = new FileInputStream(fin);
    }

    public static void main(String[] args) {
        System.out.println(ConstructorThrow.flag);
        System.out.flush();
        try {
            ConstructorThrow ct = new ConstructorThrow();
        } catch (IOException e) {
            System.out.println("file not exist : " + e.getMessage());
        }
        System.out.println(ConstructorThrow.flag);
    }
}///Output:
///false
///file not exist : C:\Users\user\IdeaProjects\LiccUtils\not-exist-file (系统找不到指定的文件。)
///true
