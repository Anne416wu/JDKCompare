package me.tomassetti.examples;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseException;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.google.common.base.Strings;
import me.tomassetti.support.DirExplorer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static me.tomassetti.examples.GenerateFuncDIc.generateFuncDic;

public class MethodCallsExample {
    public static void listMethodCalls(File projectDir) {
        new DirExplorer((level, path, file) -> path.endsWith(".java"), (level, path, file) -> {
            System.out.println(path);
            System.out.println(Strings.repeat("=", path.length()));
            try {
                new VoidVisitorAdapter<Object>() {
                    @Override
                    public void visit(MethodCallExpr n, Object arg) {
                        super.visit(n, arg);
                        System.out.println(" [L " + n.getBegin().get().line + "] " + n);
//                        System.out.println("childNodes:"+n.getChildNodes());
                        InstrumentationFunc instrumentationFunc = new InstrumentationFunc();
                        instrumentationFunc.InstrumentationFuncInterface(n,path);
                    }
                }.visit(JavaParser.parse(file), null);
                System.out.println(); // empty line
            } catch (IOException e) {
                new RuntimeException(e);
                e.printStackTrace();
            }
        }).explore(projectDir);
    }


    public static void main(String[] args){
        try{
            generateFuncDic();
            IOtoFile iOtoFile = new IOtoFile();
            IOtoFile.IOtoFile("OutputMethodCalls.txt");
        }catch (IOException e){
            e.printStackTrace();
        }
        File projectDir = new File("source_to_parse/test");
        listMethodCalls(projectDir);
    }
}
