package com.javarush.task.task18.task1819;

import java.io.*;

/* 
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) {
       try {
           BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

           String file1 = br.readLine();
           String file2 = br.readLine();
           br.close();

           FileReader fr1 = new FileReader(file1);
           FileReader fr2 = new FileReader(file2);
           ByteArrayOutputStream baos = new ByteArrayOutputStream();
           while (fr1.ready()){
               baos.write(fr1.read());
           }
           FileOutputStream fw1 = new FileOutputStream(file1);
           while (fr2.ready()){
               fw1.write(fr2.read());
           }
           baos.writeTo(fw1);
           //fw1.write(baos.toString());
           fr1.close();
           fr2.close();
           baos.close();
           fw1.close();


       }catch (Exception e){
           e.printStackTrace();
       }
    }
}
