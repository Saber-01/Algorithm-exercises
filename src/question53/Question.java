package question53;

import java.util.Scanner;

public class Question {
    public static int getTimesOfNumber(int[] array, int number) {
        if (array == null || array.length == 0) {
            System.out.println("the array is null");
            return 0;
        }
        int firstIndex = getFirstIndex(array, number, 0, array.length-1);
        int lastIndex = getLastIndex(array, number, 0, array.length-1);
        int times = 0;
        if (firstIndex != -1 && lastIndex != -1)
            times = lastIndex - firstIndex + 1;
        return times;
    }

    public static int getFirstIndex(int[] array, int number, int start, int end) {
        if (start > end) {
            return -1;
        }
        int middle = (start + end) >> 1;
        if (array[middle] == number) {
            if(middle > 0 && array[middle-1] != number || middle ==0)//重点
                return middle;
            else
                end = middle - 1;
        }
        else if (array[middle] > number) {
            end = middle - 1;
        }
        else
            start = middle + 1;
        return getFirstIndex(array,number,start,end);
    }

    public static int getLastIndex(int[] array, int number, int start, int end) {
        if (start > end) {
            return -1;
        }
        int middle = (start+end) >> 1;
        if (array[middle] == number) {
            if (middle < array.length-1 && array[middle+1] != number || middle == array.length - 1)
                return middle;
            else
                start = middle + 1;
        }
        else if (array[middle] >  number)
            end = middle -1 ;
        else
            start = middle + 1;
        return getLastIndex(array,number,start,end);
    }
    public static void main (String[] args) {
        System.out.println("input the array which each number separate with ',' ");
        Scanner scan = new Scanner(System.in);
        String temp = scan.nextLine();
        String[] str = temp.trim().split(",");
        int[] array =new int[str.length];
        for (int i = 0; i < str.length; i++) {
            try{
                array[i] = Integer.parseInt(str[i]);
            }
            catch (Exception e) {
                System.out.println("the input array is error");
                return;
            }
        }
        System.out.println("input the number :");
        int number = 0;
        if (scan.hasNextInt()) {
            number = scan.nextInt();
        }
        System.out.println("the times of the number which appears in array is"+getTimesOfNumber(array,number));
    }
}
