package question57;

import java.util.ArrayList;

public class Question {
    public static ArrayList<Integer> findNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        if (array.length < 2)
            return arrayList;
        int left = 0;
        int right = array.length - 1 ;
        while (left != right) {//还没相遇
            if (array[left] + array[right] == sum) {
                arrayList.add(array[left]);
                arrayList.add(array[right]);
                break;  // 相遇到以后 就要打断while 循环，不然会导致死循环。
            }
            else if (array[left] + array[right] < sum)
                left ++;
            else
                right -- ;
        }
        return  arrayList;
    }
    public static void main (String[] args) {
        int[] array = new int[] {1,2,4,7,11,15};
        int sum = 15;
        ArrayList<Integer> arrayList = findNumbersWithSum (array, sum);
        System.out.println("the tow number is: " +arrayList.get(0)+" and "+arrayList.get(1));
    }
}
