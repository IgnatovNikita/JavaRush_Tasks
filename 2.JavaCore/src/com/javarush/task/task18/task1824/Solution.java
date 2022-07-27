package com.javarush.task.task18.task1824;

import java.io.*;

/* 
Файлы и исключения
*/

public class Solution {
    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String newFile = null;
        while (true){
            try{
                newFile = br.readLine();
                FileReader fr = new FileReader(newFile);
                fr.close();

            }catch (FileNotFoundException e){
                System.out.println(newFile);
                try {
                    br.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                break;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
