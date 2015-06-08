package licc.utils.example.io;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.net.URI;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributes;

public class FileOperationsTest {

    private Path file2Delete = Paths.get("C:\\file2Delete.txt");
    private Path file2Copy = Paths.get("C:\\file2Copy.txt");
    private Path file2CopyDst = Paths.get("C:\\file2CopyDst.txt");
    private Path file2Move = Paths.get("C:\\file2Move.txt");
    private Path file2MoveDst = Paths.get("C:\\file2MoveDst.txt");
    private Path createDir = Paths.get("C:\\testDir");
    private Path createFile = createDir.resolve(Paths.get("testFile"));
    private Logger log = Logger.getLogger(FileOperationsTest.class);

    @Test
    public void testFileExistCheck() throws IOException {
        assert Files.exists(Paths.get("C:\\Windows"));
        assert Files.notExists(Paths.get("C:\\NotExists.txt"));
        Path p1 = Paths.get("C:\\Windows");
        Path p2 = Paths.get(URI.create("file:/C:/Windows"));
        assert Files.isSameFile(p1, p2);
        assert Files.isReadable(p1);
        assert Files.isWritable(p1);
        assert Files.isExecutable(p1);
    }

    @Test
    public void testFileCreate() {
        try {
            Files.createDirectories(createDir);
            Files.createFile(createFile);
            assert Files.exists(createDir);
            assert Files.exists(createFile);
        } catch (IOException e) {
            log.warn(e);
        }

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
        Files.deleteIfExists(createFile);
        Files.deleteIfExists(createDir);

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
        Path p = Paths.get("C:\\Windows\\System32\\notepad.exe");
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

    @Test
    public void mergeFilesTest() {
        String file1 = "C:\\mergeIn1.txt";
        String file2 = "C:\\mergeIn2.txt";

        File f1 = new File(file1);
        File f2 = new File(file2);
        File merged = new File("C:\\mergedFile.txt");

        mergeFiles(new File[]{f1, f2}, merged);
        assert Files.exists(Paths.get("C:\\mergedFile.txt"));
    }

    private void mergeFiles(File[] srcFiles, File mergedPath) {
        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            fw = new FileWriter(mergedPath);
            bw = new BufferedWriter(fw);
            BufferedReader br = null;
            for (File f : srcFiles) {
                if (f.exists()) {
                    br = new BufferedReader(new FileReader(f));
                    String line;
                    while ((line = br.readLine()) != null) {
                        bw.write(line);
                        bw.newLine();
                    }
                    br.close();
                }
            }

            bw.flush();
        } catch (IOException e) {
            log.error(e);
        } finally {
            try {
                if (bw != null)
                    bw.close();
                if (fw != null)
                    fw.close();
            } catch (IOException e) {
                log.error("writer close error: " + e);
            }

        }

    }
}