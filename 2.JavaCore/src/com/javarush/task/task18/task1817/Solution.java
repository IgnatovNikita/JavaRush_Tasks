package com.javarush.task.task18.task1817;

import java.io.*;

/* 
Пробелы
*/

public class Solution {
    public static void main(String[] args) {
        try {
            InputStream inputStream = new FileInputStream(args[0]);
            float spaces = 0;
            float chars = 0;
            char next;
            while (inputStream.available() != 0){
                next = (char) inputStream.read();
                if (next == ' ')
                    spaces++;
                chars++;
            }
            inputStream.close();
            System.out.printf("%.2f%n",spaces/chars*100);





        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
