package question48;

import java.util.Scanner;

public class Question {
    //分析用f(i)代表用i结尾的不重复子串的长度，则对当前i字符的判断有：
    //若ci没被遍历到过(即从左到右不含ci这个字符)，则显然f(i)=f(i-1)+1;
    //若 ci出现过，则定位到离开最近的也就是最新出现的ci字符的位置。
    //把i到这个ci出现位置的距离d计算出来，判别d:
    //若d <=f(i-1),说明这个字符上一次出现在了当前选择的公共子串中，此时f(i)=d;公共子序列的起点也变为上一个ci后一个字符开始。
    //若d> f(i-1)，说明这个字符上一次出现在公共子串之前，不影响，此时f(i)=f(i-1)+1;
    //遍历过程中，我们不记住每个的f(i)，只记住f(i-1)用于遍历，所以我们需要额外一个变量来存储最大的f,
    //因此在每一次f(i)=d过程中，因为最长长度会发生减少，需要在还没赋值为d之前，比较curLength和maxLength
    public static int longestOfSubstringWithoutDuplicaiton(String str) {
        if (str == null || str.length() == 0) {
            System.out.println("the input string is null");
            return 0;
        }
        char[] str1= str.toCharArray();
        int curLength = 0;//当前f(i)
        int maxLength = 0;//最大的f
        int[] lastPositon =new int[26];//字母只有26个，用于记录每个字母最后出现的位置。
        for (int i = 0; i<lastPositon.length; i++) {
            lastPositon[i] = -1;//初始都为出现，赋值-1；
        }
        for (int i = 0; i < str1.length; i++) {
            int lastIndex = lastPositon[str1[i]-'a'];//获取当前字符上一次出现的位置。
            if (lastIndex < 0 || i - lastIndex > curLength) { //未出现，或出现在当前子列之前。
                curLength ++;
            }
            else {
                if (maxLength < curLength)
                    maxLength = curLength; //存储最大的子序列长度
                curLength = i - lastIndex;//当前子序列变跟。
            }
            lastPositon[str1[i]-'a'] = i ; //当前字符出现的最新位置要更新。
        }
        if (curLength > maxLength)//因为到字符最后有可能并没有发生碰到重复的情况，所以最后要额外判断一次。
            maxLength = curLength;
        return  maxLength;
    }
    public static void main (String[] args) {
        System.out.println("input the String");
        Scanner scan =new Scanner(System.in);
        String str= scan.nextLine();
        System.out.println("the longest length of substring without duplication is"+longestOfSubstringWithoutDuplicaiton(str));
    }
}
