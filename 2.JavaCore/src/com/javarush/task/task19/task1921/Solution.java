package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {
        try(BufferedReader fileReader =new BufferedReader(new FileReader(args[0])) ){
            while (fileReader.ready()){
                String line = fileReader.readLine();
                String[] words = line.split(" ");


                int year = Integer.parseInt(words[words.length-1]);
                int month = Integer.parseInt(words[words.length-2]) - 1;
                int day = Integer.parseInt(words[words.length-3]);
                StringBuilder name = new StringBuilder(words[0]);
                if (words.length > 4){
                    for (int i = 1; i < words.length-3; i++){
                        name.append(' ');
                        name.append(words[i]);
                    }
                }
                Calendar birthDay = new GregorianCalendar(year, month, day);

                PEOPLE.add(new Person(name.toString(), birthDay.getTime()));



            }
        }catch (Exception e){
            e.printStackTrace();
        }
        for (Person p: PEOPLE){
            System.out.println(p.getName() + p.getBirthDate());
        }
    }
}
