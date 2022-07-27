package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy",Locale.getDefault());
        SimpleDateFormat newDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        int id;

        switch (args[0]){
            case "-c":
                if (args[2].equals("м")) {
                    try {
                        Date date = simpleDateFormat.parse(args[3]);

                        allPeople.add(Person.createMale(args[1], date));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
                if (args[2].equals("ж"))
                    try {
                        allPeople.add(Person.createFemale(args[1], simpleDateFormat.parse(args[3])));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                System.out.println(allPeople.size()-1);
               // System.out.println(allPeople.get(2).getName() + " " + allPeople.get(2).getSex() + " " + newDateFormat.format(allPeople.get(2).getBirthDate()));
                break;
            case "-d":
                id = Integer.parseInt(args[1]);
                allPeople.get(id).setName(null);
                allPeople.get(id).setBirthDate(null);
                allPeople.get(id).setSex(null);
                //System.out.println(allPeople.get(id).getName() + " " + allPeople.get(id).getSex() + " " + newDateFormat.format(allPeople.get(id).getBirthDate()));

                break;
            case "-u":
                id = Integer.parseInt(args[1]);
                //System.out.println(allPeople.get(id).getName() + " " + allPeople.get(id).getSex() + " " + newDateFormat.format(allPeople.get(id).getBirthDate()));

                allPeople.get(id).setName(args[2]);
                try {
                    allPeople.get(id).setBirthDate(simpleDateFormat.parse(args[4]));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                if (args[3].equals("м"))
                    allPeople.get(id).setSex(Sex.MALE);
                if (args[3].equals("ж"))
                    allPeople.get(id).setSex(Sex.FEMALE);
               // System.out.println(allPeople.get(id).getName() + " " + allPeople.get(id).getSex() + " " + newDateFormat.format(allPeople.get(id).getBirthDate()));

                break;
            case "-i":
                id = Integer.parseInt(args[1]);
                if (allPeople.get(id).getSex().equals(Sex.MALE))
                    System.out.println(allPeople.get(id).getName() + " " + "м" + " " + newDateFormat.format(allPeople.get(id).getBirthDate()));
                if (allPeople.get(id).getSex().equals(Sex.FEMALE))
                    System.out.println(allPeople.get(id).getName() + " " + "ж" + " " + newDateFormat.format(allPeople.get(id).getBirthDate()));

                break;
        }
    }
}
