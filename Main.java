package Aravan;

import java.util.Scanner;

public class Main {

        public static void main(String[] args) throws Exception {
            Scanner scn = new Scanner(System.in);
            String exp = scn.nextLine();
            char action;
            String[] data;
            if (exp.contains(" + ")) {
                data = exp.split(" \\+ ");
                action = '+';
            } else if (exp.contains(" - ")) {
                data = exp.split(" - ");
                action = '-';
            } else if (exp.contains(" * ")) {
                data = exp.split(" \\* ");
                action = '*';
            } else if (exp.contains(" / ")) {
                data = exp.split(" / ");
                action = '/';
            }else{
                throw new Exception("Некорректный знак действия");
            }
            if (action == '*' || action == '/') {
                if (data[1].contains("\"")) throw new Exception("Строчку можно делить или умножать только на число");
            }
            for (int i = 0; i < data.length; i++) {
                data[i] = data[i].replace("\"", "");
            }

            if (action == '+') {
                printInQuotes(data[0] + data[1]);
            } else if (action == '*') {
                int multiplier = Integer.parseInt(data[1]);
                String result = "";
                for (int i = 0; i < multiplier; i++) {
                    result+=data[0];
                }
                printInQuotes(result);
            } else if (action == '-') {
                int index = data[0].indexOf(data[1]);
                if(index == -1){
                    printInQuotes(data[0]);
                }else{
                    String result = data[0].substring(0, index);
                    result+=data[0].substring(index+data[1].length());
                    printInQuotes(result);
                }
            }else{
                int newLen = data[0].length()/Integer.parseInt(data[1]);
                String result = data[0].substring(0,newLen);
                printInQuotes(result);
            }


        }
        static void printInQuotes(String text){
            System.out.println("\""+text+"\"");
        }
    }

//Input:
//"100" + "500"
//
//Output:
//"100500"
//
//Input:
//"Hi World!" - "World!"
//
//Output:
//"Hi "
//
//Input:
//"Bye-bye!" - "World!"
//
//Output:
//"Bye-bye!"
//
//Input:
//"Java" * 5
//
//Output:
//"JavaJavaJavaJavaJava"
//
//Input:
//"Example!!!" / 3
//
//Output:
//"Exa"
//
