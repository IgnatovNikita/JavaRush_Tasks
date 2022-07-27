package com.javarush.task.task18.task1821;

import java.io.*;
import java.util.*;

/* 
Встречаемость символов
*/

public class Solution {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream(args[0]);){
            Map<Character, Integer> res = new HashMap<>();
            while (fis.available() != 0){
                char next = (char) fis.read();
                if (res.containsKey(next)){
                    res.put(next, res.get(next) + 1);
                }else
                    res.put(next, 1);
            }
            ArrayList<Character> list = new ArrayList<>(res.keySet());
            list.sort(new Comparator<Character>() {
                @Override
                public int compare(Character o1, Character o2) {
                    return ((int) o1 -(int) o2);
                }
            });
            for (char ch: list){
                System.out.println(ch +" " + res.get(ch));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
