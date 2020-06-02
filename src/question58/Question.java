package question58;

import java.util.Scanner;

public class Question {
    public static String reverse (String str) {
        if (str.trim().length() == 0) {
            return str;
        }
        String res = "";
        String[] temp = str.split(" ");
        for (int i = 0; i < temp.length; i++) {
            res = temp[i] + res;
            if (i != temp.length-1)
                res = " " + res;
        }
        return  res;
    }
    public static void main (String[] args) {
        System.out.println("input the String");
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        System.out.println("the reversed string is :" +reverse(str));
    }
}
