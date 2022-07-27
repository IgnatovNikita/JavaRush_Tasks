package com.javarush.task.task19.task1919;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeMap;

/* 
Считаем зарплаты
*/

public class Solution {
    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new FileReader(args[0]));
            HashMap<String, Double> res = new HashMap<>();
            while (br.ready()){
                String s = br.readLine();
                String[] s2 = s.split(" ");
                if(res.containsKey(s2[0])){
                    res.put(s2[0], res.get(s2[0]) + Double.parseDouble(s2[1]));
                }else {
                    res.put(s2[0], Double.parseDouble(s2[1]));
                }
            }
            br.close();

            ArrayList<String> ar = new ArrayList(res.keySet());
            Collections.sort(ar);
            for (String a: ar){
                System.out.println(a + " " + res.get(a));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
