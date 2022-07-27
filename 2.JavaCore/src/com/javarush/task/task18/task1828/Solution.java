package com.javarush.task.task18.task1828;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Прайсы 2
*/

public class Solution {
    public static void main(String[] args) {
        if (args.length == 0)
            return;

       ArrayList<String> fileStrings = new ArrayList<>();
        try {
            if (args[0].equals("-d")){
                try {
                    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                    String file = br.readLine();
                    br = new BufferedReader(new FileReader(file));
                    while (br.ready()) {
                        String nextLine = br.readLine();
                        if (args[1].length() == 8){
                            if (!nextLine.startsWith(args[1]))
                                fileStrings.add(nextLine);}
                        if (!nextLine.startsWith(args[1]+ " "))
                             fileStrings.add(nextLine);
                    }
                    PrintWriter pw = new PrintWriter(new FileWriter(file, false));
                    for (String s: fileStrings){
                        pw.write(s);
                        pw.write('\n');
                    }
                    pw.close();
                    br.close();
                }catch (Exception e){
                    e.printStackTrace();
                }

            }

            if (args[0].equals("-u")) {
                StringBuilder productName = new StringBuilder();
                StringBuilder id = new StringBuilder(args[1]);
                while (id.length() < 8){
                    id.append(' ');
                }
                for (int i = 2; i < args.length - 2; i++) {
                    productName.append(args[i]);
                    if (i != args.length - 3)
                        productName.append(' ');
                }

                while (productName.length() < 30) {
                    productName.append(" ");
                }
                StringBuilder price = new StringBuilder(args[args.length - 2]);
                while (price.length() < 8) {
                    price.append(' ');
                }
                StringBuilder quantity = new StringBuilder(args[args.length - 1]);
                while (quantity.length() < 4)    quantity.append(' ');
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String file = br.readLine();
                br = new BufferedReader(new FileReader(file));

                StringBuilder newLine = id.append(productName).append(price).append(quantity);
                while (br.ready()) {
                    String nextLine = br.readLine();
                    if (((args[1].length() == 8)&(nextLine.startsWith(args[1]))))
                        fileStrings.add(newLine.toString());
                    else if (nextLine.startsWith(args[1]+ " "))
                        fileStrings.add(newLine.toString());
                    else fileStrings.add(nextLine);
                }

                PrintWriter pw = new PrintWriter(new FileWriter(file, false));
                for (String s: fileStrings){
                    pw.write(s);
                    pw.write('\n');
                }


                br.close();
                pw.close();
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
