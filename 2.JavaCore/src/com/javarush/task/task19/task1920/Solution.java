package com.javarush.task.task19.task1920;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Самый богатый
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
            double max = Collections.max(res.values());
            ArrayList<String> ar = new ArrayList<>();
            for (String a : res.keySet()){
                if (res.get(a) == max)
                    ar.add(a);
            }

            Collections.sort(ar);
            for (String a: ar){
                System.out.println(a);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
