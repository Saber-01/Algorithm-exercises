package question58;

import java.util.Scanner;

public class SubQuestion {
    public static String leftRotateString (String str, int n) {
        String res = "";
        if (str.length() == 0)
            return  res;
        n = n% str.length(); //如果N大于数组长度，求余数，因为完整左移N位是会和原数相同。
        String sub1 = str.substring(0,n);
        String sub2 = str.substring(n,str.length());
        res = sub2 + sub1;
        return  res;
    }
    public static void main (String[] args) {
        System.out.println("input the String");
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        System.out.println("input the n");
        int n = scan.nextInt();
        System.out.println("the reversed string is :" +leftRotateString(str,n));
    }
}
