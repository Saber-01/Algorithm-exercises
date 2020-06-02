package question50;

import java.util.Scanner;

public class Question {
    //建立一个0到256的哈希表，key为字符的ascii码，value为对应的字符在字符串中出现的次数。
    public static char findFirstNotRepeatingChar (String str) {
        if (str == null || str.length() == 0) {
            System.out.println(" the string is null");
            return '0';
        }
        int[] timesOfChar =new int[256];//因为一共有256个字符类型
        char[] strs = str.toCharArray();
        for (int i = 0;  i < strs.length; i++) {
            timesOfChar[strs[i]]++;
        }
        for (int i = 0; i < strs.length; i++) {
            if (timesOfChar[strs[i]] == 1)
                return strs[i];
        }
        return '\u0000';
    }
    public static void main (String[] args) {
        System.out.println("input the string, print out the first char which appears one time");
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        System.out.println("the out char is:"+findFirstNotRepeatingChar(str));
    }
}
