package licc.utils.example.io;

import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileOperationsTest {

    @Test
    public void testFileExistCheck() throws IOException {
        assert Files.exists(Paths.get("E:\\test.txt"));
        assert Files.notExists(Paths.get("E:\\NotExists.txt"));
        Path p1 = Paths.get("D:\\RWorkspace\\GettingAndCleaningData\\temp.xlsx");
        Path p2 = Paths.get(URI.create("file:/D:/RWorkspace/GettingAndCleaningData/temp.xlsx"));
        assert Files.isSameFile(p1, p2);
        assert Files.isReadable(p1);
        assert Files.isWritable(p1);
        assert Files.isExecutable(p1);
    }
}