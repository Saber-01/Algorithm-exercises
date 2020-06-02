package question61;
import java.util.Arrays;

public class Question {
    public static boolean isContinuous(int[] numbers) {
        if (numbers.length != 5) {
            return  false;
        }
        int zeroCount = 0 ;//统计0的个数。
        for (int i = 0; i < 5; i++) {
            if (numbers[i] == 0)
                zeroCount++;
            else if (numbers[i] < 0 || numbers[i] > 13 )
                return  false;
        }
//        for (int i = 0; i < numbers.length; i++) {//冒泡排序
//            for (int j = numbers.length-1; j > i; j--) {
//                if (numbers[j] < numbers[j - 1]) {
//                    int temp = numbers[j];
//                    numbers[j] = numbers[j - 1];
//                    numbers[j - 1] = temp;
//                }
//            }
//        }
        Arrays.sort(numbers);
        int dis = 0;
        for (int i = numbers.length - 1; i > zeroCount; i--) {
            if (numbers[i] == numbers[i - 1] )
                return false;
            else
                dis += numbers[i] - numbers[i-1] - 1;
        }
        if (dis <= zeroCount)
            return true;
        else
            return false;
    }
    public static void main (String[] args) {
        int[] array = new int[]{2,0,6,3,0};
        if (isContinuous(array))
            System.out.println("the input is continuous");
        else
            System.out.println("the input is not continuous");
    }
}
