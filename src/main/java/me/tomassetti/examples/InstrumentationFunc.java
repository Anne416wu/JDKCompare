package me.tomassetti.examples;


import com.github.javaparser.ast.expr.MethodCallExpr;

import java.io.*;
import java.nio.file.Path;

public class InstrumentationFunc {
    private  boolean judgeFuncInDic(MethodCallExpr n){
        String funcName = n.getName().toString();
        return GenerateFuncDIc.funcDicMap.containsKey(funcName.toLowerCase().hashCode());
    }
    private boolean judgeFuncReturn(MethodCallExpr n){
        String funcName = n.getName().toString();
        return GenerateFuncDIc.funcDicMap.containsKey(funcName);
    }
    public void InstrumentationFuncInterface(MethodCallExpr n, String path){
        if (!judgeFuncInDic(n)){
            printObjectToFile(n,path);
        }
    }
    public void printObjectToFile(MethodCallExpr n,String path){
        try{
            String filename = path.substring(path.lastIndexOf('/'))+"_"+
                    n.getBegin().get().line + "_" + n + "_jdk8";
            String filePath = "out"+filename;
            File writeFile = new File(filePath);
            writeFile.createNewFile();
            new File(filePath).createNewFile();
            BufferedWriter out = new BufferedWriter(new FileWriter(writeFile));
            out.write("我会写入文件啦1\r\n"); // \r\n即为换行
            out.write("我会写入文件啦2\r\n"); // \r\n即为换行
            out.flush(); // 把缓存区内容压入文件
        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
