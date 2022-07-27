package com.javarush.task.task17.task1711;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy",Locale.getDefault());
    private static SimpleDateFormat newDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }
    private static void create(String name, String sex, String sdate){

        try {

            Date date = simpleDateFormat.parse(sdate);
            if (sex.equals("м"))
                allPeople.add(Person.createMale(name, date));
            if (sex.equals("ж"))
                allPeople.add(Person.createFemale(name, date));

        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(allPeople.size()-1);
        //inf(String.valueOf(allPeople.size()-1));
    }

    private static void delete(String sId){
        int  id = Integer.parseInt(sId);
        allPeople.get(id).setName(null);
        allPeople.get(id).setBirthDate(null);
        allPeople.get(id).setSex(null);
    }

    private static  void update(String sid, String name, String sex, String sdate){
        try{
            int id = Integer.parseInt(sid);
            //System.out.println(allPeople.get(id).getName() + " " + allPeople.get(id).getSex() + " " + newDateFormat.format(allPeople.get(id).getBirthDate()));

            allPeople.get(id).setName(name);
            allPeople.get(id).setBirthDate(simpleDateFormat.parse(sdate));

            if (sex.equals("м"))
                allPeople.get(id).setSex(Sex.MALE);
            if (sex.equals("ж"))
                allPeople.get(id).setSex(Sex.FEMALE);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static  void inf(String sid){
        int id = Integer.parseInt(sid);
        if (allPeople.get(id).getSex().equals(Sex.MALE))
            System.out.println(allPeople.get(id).getName() + " " + "м" + " " + newDateFormat.format(allPeople.get(id).getBirthDate()));
        if (allPeople.get(id).getSex().equals(Sex.FEMALE))
            System.out.println(allPeople.get(id).getName() + " " + "ж" + " " + newDateFormat.format(allPeople.get(id).getBirthDate()));

    }
    public static void main(String[] args) {
        //start here - начни тут



        switch (args[0]){
            case "-c":

                    for (int i = 1; i <= args.length - 3; i += 3){
                        synchronized (allPeople) {
                            create(args[i], args[i + 1], args[i + 2]);
                        }
                    }


                break;
            case "-d":
                synchronized (allPeople){
                    for (int i = 1; i < args.length; i ++){
                        delete(args[i]);}
                }
                break;
            case "-u":
                synchronized (allPeople){
                    for (int i = 1; i <= args.length - 4; i += 4){
                        update(args[i], args[i+1], args[i+2], args[i+3]);}
                    // System.out.println(allPeople.get(id).getName() + " " + allPeople.get(id).getSex() + " " + newDateFormat.format(allPeople.get(id).getBirthDate()));
                }
                break;
            case "-i":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        inf(args[i]);
                    }
                }
                break;
        }
    }
}
