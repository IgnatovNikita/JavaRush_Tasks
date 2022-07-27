package com.javarush.task.task18.task1826;

import java.io.*;

/* 
Шифровка
*/

public class Solution {
    public static void main(String[] args) {
       try {
           FileReader fr = new FileReader(args[1]);
           FileWriter fw = new FileWriter(args[2]);
           switch (args[0]){
               case "-e":
                    while (fr.ready()){
                        fw.write(fr.read()+2);
                    }
                   break;
               case "-d":
                   while (fr.ready()){
                       fw.write(fr.read()-2);
                   }
                   break;
           }
           fr.close();
           fw.close();
       }catch (Exception e){
           e.printStackTrace();
       }


    }

}
