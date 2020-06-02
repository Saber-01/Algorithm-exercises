package question45;

import java.util.Arrays;
import java.util.Comparator;

public class Question {
    //需要定义一个整数串的比较规则，若串m和串n ，mn>nm,则说明n 比m 小，n 应该放在m左边
    //需要用到数组的排序算法，定义一个比较规则。
    public  static int printMinNumber(int[] array){
        //先把整数数组转换成字符串数组。
        if (array == null || array.length == 0) {
            System.out.println(" array is null ");
            return 0;
        }
        String[] str =new String[array.length];
        for (int i =0; i < str.length; i++) {
            str[i]=String.valueOf(array[i]);
        }
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String c1=o1+o2;
                String c2=o2+o1;
                return  c1.compareTo(c2);//如果c1比c2小，说明o1比o2小。
            }
        });
        //到这里str中已经排完序，剩下就是将String[]转化成整数。
        String s="";
        for (int i=0; i < str.length; i++) {
            s=s+str[i];
        }
        return  Integer.parseInt(s);
    }
    public static void main (String[] args) {
        int[] array=new int[]{3,32,321};
        System.out.println("the min of the sorted numbers is:" +printMinNumber(array));
    }
}
