package question51;

import java.util.Scanner;

public class Question {
    //利用归并排序的思想，先分成最小的每一对只含1个数的数组，每一对排序合并的过程中，同时计算count。
    //之所以要排序，是为了排除重复计算。
    public static int getInversePairs(int[] array) {
        if (array == null || array.length == 0) {
            System.out.println("the array is null");
            return 0;
        }
        int[] sortedArray = new int[array.length];
        for ( int i=0; i < sortedArray.length; i++) {
            sortedArray[i] = array[i];
        }
        return getInversePairsCore(array, sortedArray, 0, array.length - 1);
    }

    public static int getInversePairsCore(int[] array, int[] sortedArray, int start, int end) {
        if (start == end) {//分割成最小了
            sortedArray[start] = array[start];
            return 0;
        }
        int length = (end-start)>>1;//定义下一段长度
        int left = getInversePairsCore(sortedArray, array, start, start + length); //注意前两个参数要调换。
        int right = getInversePairsCore(sortedArray, array, start+length+1, end);

        int i = start+length; //左半部分数组指针，初始在末尾
        int j =end;//右半部分数组指针，初始在末尾
        int sortedIndex = end; //排序数组指针，初始在末尾
        int count = 0;//用于排序时，统计。
        while (i >= start && j >= start+length+1 ) {
            if (array[i] > array[j]) {//左边大，
                count += j-start-length;  //注意这边要累加
                sortedArray[sortedIndex--] = array[i--];
            }
            else {
                sortedArray[sortedIndex--] = array[j--];
            }
        }
        while(i >= start) {
            sortedArray[sortedIndex--] =array[i--];
        }
        while(j >= start+length+1) {
            sortedArray[sortedIndex--] =array[j--];
        }
        count += left+right;
        return  count;
    }

    public static void main(String[] args) {
        int[] array = new int[]{7, 5, 6, 4};
        System.out.println("the count of the inverse pairs is" + getInversePairs(array));
    }
}
