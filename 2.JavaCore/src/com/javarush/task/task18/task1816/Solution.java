package com.javarush.task.task18.task1816;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 
Английские буквы
*/

public class Solution {
    public static void main(String[] args) {
        int count = 0;
        try (  FileInputStream fis = new FileInputStream(args[0])){

         char next;
          while (fis.available() != 0){
              next = (char) fis.read();
              if ((next >= 'a' & next <= 'z')||(next >= 'A' & next <= 'Z')){
                  count++;
              }
          }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        System.out.println(count);
    }

}
