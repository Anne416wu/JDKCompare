package me.tomassetti.examples;

import com.google.common.hash.HashCode;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class GenerateFuncDIc {
    public static Map<Integer,String> funcDicMap = new HashMap<Integer,String>();
    public static void generateFuncDic() throws IOException {
        System.out.println("genf");
        File classFile = new File("OutputListClasses.txt");
        InputStreamReader reader = new InputStreamReader(new FileInputStream(classFile)); // 建立一个输入流对象reader
        BufferedReader bufferedReader = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            line=line.trim();
            if(line.startsWith("*")){
                funcDicMap.put(line.substring(2).toLowerCase().hashCode(),line.substring(2).toLowerCase());
            }
        }
    }
}
