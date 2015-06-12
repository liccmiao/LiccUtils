package licc.utils.example.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Created by mengchenli on 2015/6/12.
 */
public class UnzipJar {
    public static void unzipJarFile(Path jar) throws IOException {
        if (!Files.exists(jar))
            return;

        String fnJar = jar.getFileName().toString();
        String fn = fnJar.substring(0, fnJar.lastIndexOf(".jar"));
        Path dst = jar.getParent().resolve(fn);
        Files.createDirectory(dst);
        JarFile jf = new JarFile(jar.toString());
        //create directory
        for (Enumeration<JarEntry> enums = jf.entries(); enums.hasMoreElements(); ) {
            JarEntry entry = enums.nextElement();
            if (entry.isDirectory()) {
                Files.createDirectories(dst.resolve(entry.getName()));
            }
        }
        //copy file
        for (Enumeration<JarEntry> enums = jf.entries(); enums.hasMoreElements(); ) {
            JarEntry entry = enums.nextElement();
            if (!entry.isDirectory()) {
                Files.copy(jf.getInputStream(entry), dst.resolve(entry.getName()),
                        StandardCopyOption.REPLACE_EXISTING);
            }
        }
    }
}
