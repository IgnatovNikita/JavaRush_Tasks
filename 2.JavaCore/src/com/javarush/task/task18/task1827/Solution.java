package com.javarush.task.task18.task1827;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Прайсы
*/
// C:\Users\User\Desktop\1.txt
public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length == 0)
            return;

        if (args[0].equals("-c")) {
            StringBuilder productName = new StringBuilder();
            for (int i = 1; i < args.length - 2; i++) {
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
            while (quantity.length() < 4)
                quantity.append(' ');


            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String file = br.readLine();
            br = new BufferedReader(new FileReader(file));


            int maxId = 0;
            while (br.ready()) {
                String nextline = br.readLine().substring(0, 8);
                if (nextline.endsWith(" "))
                    nextline = nextline.substring(0, nextline.indexOf(" "));

                int nextId = Integer.parseInt(nextline);
                if (nextId > maxId)
                    maxId = nextId;
            }
            StringBuilder sId = new StringBuilder(String.valueOf(maxId + 1));
            while (sId.length() < 8) {
                sId.append(" ");
            }


            PrintWriter pw = new PrintWriter(new FileWriter(file, true));
            if (args[0].equals("-c")) {
                pw.append('\n');
                pw.append(sId.toString()).append(String.valueOf(productName)).append(String.valueOf(price)).append(String.valueOf(quantity));
            }


            br.close();
            pw.close();
        }
    }
}
