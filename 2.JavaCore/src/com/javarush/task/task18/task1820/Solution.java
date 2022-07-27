package com.javarush.task.task18.task1820;

import java.io.*;
import java.util.Scanner;

/* 
Округление чисел
*/

public class Solution {
    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String file1 = br.readLine();
            String file2 = br.readLine();
            br = new BufferedReader(new FileReader(file1));
            PrintWriter wr = new PrintWriter(new FileWriter(file2));


            String[] num = br.readLine().split(" ");
            for (String n: num){
                double d = Double.parseDouble(n);
                int i = (int) Math.round(d);
                wr.write(i + " ");
                //wr.write(' ' );
              // System.out.println(i);
            }


           // wr.flush();
            br.close();
            //sc.close();
            wr.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }


    }
}
