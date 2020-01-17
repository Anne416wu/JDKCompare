package me.tomassetti.examples;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class InstrumentationFunc {
    public static void printObjectToFile(String filename,String context){
        try{
            File writeFile = new File("");
            if (!writeFile.exists())
             writeFile.createNewFile();
             FileWriter writer = new FileWriter(writeFile);
             BufferedWriter out = new BufferedWriter(writer);
             out.write("我会写入文件啦1\r\n"); // \r\n即为换行
             out.write("我会写入文件啦2\r\n"); // \r\n即为换行
             out.flush(); // 把缓存区内容压入文件
        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
