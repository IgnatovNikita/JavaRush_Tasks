package com.javarush.task.task19.task1923;

import java.io.*;

/* 
Слова с цифрами
*/

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(args[0]));
            FileWriter pw = (new FileWriter(args[1]));

            while (br.ready()){
                String line = br.readLine();
                String[] words = line.split(" ");
                for (String w: words){
                    if (w.matches(".+[0-9].+")){
                        pw.write(w + " ");
                    }

                }
            }

            br.close();
            pw.close();




        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }
}
