package licc.utils.example.io;

import junit.framework.TestCase;

import java.nio.file.Paths;

public class UnzipJarTest extends TestCase {

    public void testUnzipJarFile() throws Exception {
        UnzipJar.unzipJarFile(Paths.get("./out/log4j-1.2.16.jar"));
    }
}