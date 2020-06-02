package question56;

public class SubQuestion {
    public static int findNumberAppearOnce(int[] array) {
        if (array == null || array.length == 0)
            return 0;
        int[] bitSum = new int[32];//存储每一个位数出现次数。
        for (int i = 0; i < array.length; i++) {//对每个数进行检查计算位数上1个数
            int bitCheck = 1 ; //用于查看位数上是否为1
            for (int j = 31; j >= 0; j--) { //从最后一位开始
                if ( (array[i] & bitCheck) != 0)//对应位为1；
                    bitSum[j] ++;
                bitCheck = bitCheck << 1;
            }
        }
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = result << 1; //左移一位。
            result = result + bitSum[i] % 3;
        }
        return  result;
    }
    public static void main (String[] args) {
        int[] array = new int[] {1,1,1,2,2,2,4,5,5,5};
        int number = findNumberAppearOnce(array);
        System.out.println(" the number which appears once is: "+number);
    }
}
