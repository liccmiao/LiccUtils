package licc.utils.example.io;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.FileAttribute;

public class FileOperationsTest {

    private Path file2Delete = Paths.get("E:\\file2Delete.txt");
    private Path file2Copy = Paths.get("E:\\file2Copy.txt");
    private Path file2CopyDst = Paths.get("E:\\file2CopyDst.txt");
    private Path file2Move = Paths.get("E:\\file2Move.txt");
    private Path file2MoveDst = Paths.get("E:\\file2MoveDst.txt");

    private Logger log = Logger.getLogger(FileOperationsTest.class);

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

    @Before
    public void setUp() throws Exception {
        if (Files.notExists(file2Delete))
            Files.createFile(file2Delete);
        if (Files.notExists(file2Copy))
            Files.createFile(file2Copy);
        Files.deleteIfExists(file2CopyDst);
        if (Files.notExists(file2Move))
            Files.createFile(file2Move);
        Files.deleteIfExists(file2MoveDst);
    }

    @Test
    public void testFileDelete() {
        try {
            assert Files.exists(file2Delete);
            Files.delete(file2Delete);
        } catch (NoSuchFileException | DirectoryNotEmptyException e) {
            log.warn(e);
        } catch (IOException e) {
            log.warn(e);
        }
    }

    @Test
    public void testFileCopy() {
        try {
            Files.copy(file2Copy, file2CopyDst, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.COPY_ATTRIBUTES);
            assert (Files.exists(file2CopyDst));
        } catch (IOException e) {
            log.warn(e);
        }
    }

    @Test
    public void testFileMove() {
        try {
            Files.move(file2Move, file2MoveDst, StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING);
            assert (Files.exists(file2MoveDst));
        } catch (IOException e) {
            log.warn(e);
        }
    }

    @Test
    public void testFileAtrributes() {
        Path p = Paths.get("C:\\Program Files\\Java\\jdk1.7.0\\bin\\java.exe");
        try {
            BasicFileAttributes basicAttr = Files.readAttributes(p, BasicFileAttributes.class);
            System.out.println("[size=" + basicAttr.size() + "]" +
                            "[isRegularFile=" + basicAttr.isRegularFile() + "]" +
                            "[isDirectory=" + basicAttr.isDirectory() + "]" +
                            "[isSymbolicLink=" + basicAttr.isSymbolicLink() + "]" +
                            "[isOther=" + basicAttr.isOther() + "]" +
                            "[creationTime=" + basicAttr.creationTime() + "]" +
                            "[lastAccessTime=" + basicAttr.lastAccessTime() + "]" +
                            "lastModifiedTime=" + basicAttr.lastModifiedTime() + "]"
            );

            DosFileAttributes dosAttr = Files.readAttributes(p, DosFileAttributes.class);
            System.out.println("[isArchive=" + dosAttr.isArchive() + "]" +
                    "[isHidden=" + dosAttr.isHidden() + "]" +
                    "[isReadOnly=" + dosAttr.isReadOnly() + "]" +
                    "[isSystem=" + dosAttr.isSystem() + "]");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}