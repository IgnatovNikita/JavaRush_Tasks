package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
        String file = br.readLine();

            while (!file.equals("exit")){
                ReadThread newThread = new ReadThread(file);
                newThread.start();
                file = br.readLine();
            }


        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static class ReadThread extends Thread {
        String file;
        public ReadThread(String fileName) {
            file = fileName;
            //implement constructor body
        }

        @Override
        public void run() {
            try(FileReader fr = new FileReader(file)){
                Map<Integer, Integer> count = new HashMap<>();
                while (fr.ready()){
                    int nextByte = fr.read();
                    if (count.containsKey(nextByte)){
                        count.put(nextByte, count.get(nextByte) + 1);
                    }else {
                        count.put(nextByte, 1);
                    }
                }
                int max = 0;
                int res = -1;

                for (Integer i: count.keySet()){
                    if (count.get(i) > max){
                        max = count.get(i);
                        res = i;
                    }
                }

                resultMap.put(file, res);


            }catch (Exception e){
                e.printStackTrace();
            }
        }
        // implement file reading here - реализуйте чтение из файла тут
    }
}
