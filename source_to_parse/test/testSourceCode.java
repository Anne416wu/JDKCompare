package me.tomassetti.examples;

import java.io.Reader;
import java.util.SortedSet;
import java.util.TreeSet;

public class PlayGroubnd {
    public void mytest(SortedSet<Integer> s){
        System.out.println(s);
    }
    public static void main(String[] args){
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i=0; i<10;i++){
            treeSet.add(i);
        }
        mytest();
        SortedSet<Integer> s = treeSet.subSet(0,2);
    }
}
