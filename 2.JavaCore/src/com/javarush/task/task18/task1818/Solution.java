package com.javarush.task.task18.task1818;

import java.io.*;

/* 
Два в одном
*/

public class Solution {
    public static void main(String[] args) {
       try {
           BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           String f1 = br.readLine();
           String f2 = br.readLine();
           String f3 = br.readLine();

           BufferedReader br2 = new BufferedReader(new FileReader(f2));
           BufferedReader br3 = new BufferedReader(new FileReader(f3));
           BufferedWriter fw1 = new BufferedWriter(new FileWriter(f1));

           while (br2.ready()) {
               fw1.write(br2.read());
           }
           while ((br3.ready())) {
               fw1.write(br3.read());
           }
           fw1.flush();
           br.close();
           br2.close();
           br3.close();
           fw1.close();
       }catch (Exception e){
           e.printStackTrace();
       }
    }
}
