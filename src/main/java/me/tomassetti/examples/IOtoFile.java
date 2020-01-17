package me.tomassetti.examples;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class IOtoFile {
    public static void IOtoFile(String filename)throws IOException {
        System.out.println("库函数输出到文件"+filename);
        File f=new File(filename);
        f.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(f);
        PrintStream printStream = new PrintStream(fileOutputStream);
        System.setOut(printStream);
    }
}
