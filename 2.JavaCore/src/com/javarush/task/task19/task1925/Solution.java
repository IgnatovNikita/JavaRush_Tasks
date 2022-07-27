package com.javarush.task.task19.task1925;

import java.io.*;
import java.util.ArrayList;

/* 
Длинные слова
*/

public class Solution {
    public static void main(String[] args) {
        try (  BufferedReader br = new BufferedReader(new FileReader(args[0]));
               FileWriter pw = (new FileWriter(args[1]))){
            int i =0;
            while (br.ready()){
                String line = br.readLine();
                String[] words = line.split(" ");
                for (String w: words){
                    if (w.length() > 6){
                        i++;
                        if (i == 1)
                            pw.write(w);
                        else

                        pw.write("," + w);
                    }

                }
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }
}
