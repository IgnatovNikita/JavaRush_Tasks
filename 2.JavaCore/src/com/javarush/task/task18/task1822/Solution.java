package com.javarush.task.task18.task1822;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Поиск данных внутри файла
*/

public class Solution {
    public static void main(String[] args) {

        try {
            //int id = Integer.getInteger(args[0]);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            br = new BufferedReader(new FileReader(br.readLine()));
            String line;
            while (br.ready()){
                line = br.readLine();
                if (line.startsWith(args[0]+ " "))
                    System.out.println(line);
            }
            br.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
