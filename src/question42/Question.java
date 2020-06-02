package question42;

public class Question {
    public static void main(String[] args) {
        int[] array = {1, -2, 3, 10, -4, 7, 2, -5};
        System.out.println(greatestSumOfSubArray(array));
    }

    public static int greatestSumOfSubArray(int[] array) {
        if (array == null && array.length == 0) {
            System.out.println("array is null");
            return 0;
        }
        int[] A = new int[array.length];
        A[0]=array[0];//用于储存累加到目前为止和最大的值，
        int Max = A[0];
        for (int i = 1; i < array.length; i++) {
            A[i] = Math.max(A[i-1]+array[i],array[i]);//如果遇到加完当前前面累加的值，反而比当前值小，则舍弃前面累加值，重新开始累加子串，赋值为当前值。
            Max=Math.max(A[i],Max);//每次累加，都检查累加最大值，进行刷新。
        }
        return  Max;
    }
}
