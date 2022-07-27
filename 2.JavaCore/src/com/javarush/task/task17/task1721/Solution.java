package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
       // Solution sol = new Solution();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String first = br.readLine();
            String second = br.readLine();
            BufferedReader fr = new BufferedReader(new FileReader(first));
            BufferedReader sr = new BufferedReader(new FileReader(second));
            while (fr.ready()){
                allLines.add(fr.readLine());
              //  System.out.println(allLines.get(allLines.size()-1));
            }

            while (sr.ready()){
                forRemoveLines.add(sr.readLine());
                //System.out.println(forRemoveLines.get(forRemoveLines.size()-1));
            }
            br.close();
            fr.close();
            new Solution().joinData();
            /*for (String s: allLines){
                System.out.println(s);
            }*/


        } catch (Exception ioException) {
            ioException.printStackTrace();
        }


    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)){
            allLines.removeAll(forRemoveLines);
        }else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
