package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String file = br.readLine();
            br.close();
            br = new BufferedReader(new FileReader(file));
            while (br.ready()){
                String nextLine = br.readLine();
                String[] newwords = nextLine.split(" ");
                int count = 0;
                for (String s: newwords){
                    for (String w: words){
                        if (s.equals(w))
                            count++;
                    }
                }
                if (count == 2)
                    System.out.println(nextLine);

            }
        br.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
