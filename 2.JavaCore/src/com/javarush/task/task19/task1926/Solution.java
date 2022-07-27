package com.javarush.task.task19.task1926;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Перевертыши
*/

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader br2 = new BufferedReader(new FileReader(br.readLine()));
            while (br2.ready()) {
                System.out.println(new StringBuilder(br2.readLine()).reverse());
            }
            br.close();
            br2.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
