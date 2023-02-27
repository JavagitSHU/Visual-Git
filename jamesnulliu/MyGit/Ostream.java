package com.jamesnulliu.MyGit;

import java.io.FileOutputStream;
import java.io.IOException;

public class Ostream{
    String loginfo = "";
    public void output(Object x){
        System.out.println(x);
    }
    public void log(Object x){
        String stringx = x.toString();
        // ==============================================================
        // 1. Log content should be more specific.
        // ================================= From JamesNULLiu 26/Feb/2023
        loginfo = stringx + "\n"+"===================="+"\n";
        byte [] a = loginfo.getBytes();
        try {
            FileOutputStream out = new FileOutputStream("loginfo.txt",true);
            out.write(a,0,a.length);
            out.close();
        }
        catch (IOException e){
            System.out.println(e);
        }
    }
}

