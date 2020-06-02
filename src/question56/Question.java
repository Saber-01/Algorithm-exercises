package question56;

public class Question {
    //首先从一个只有一个数出现一次，其他出现2次的数组中找出这个数开始思考。
    //只要把数组每个数都进行异或，因为相同数异或结果为0。而这个数与零异或还是本身。
    //而当这个数组中有2个数只出现一次时候，需要先进行拆分，拆分出2个组合，对这2个组合中的数进行分别进行异或，即可得到这2个数
    //而拆分的标准需要进一步思考，可以发现，2个不相同的数异或以后，只有不同位数的地方会设置为1，
    //找到所有数组异或的结果中最右边一个1，把其当做判断标准，将数组分为2组
    //可以知道，2个只出现一次的数，肯定被分开了，而且每一对相同的数也会出现在同一分组中，异或还是为0.
    //接着对2组进行分开异或，就能得到2个只出现1次的数
    public static void findNumsAppearOnce(int[] array, int[] num1, int[] num2) {
        num1[0] = 0;
        num2[0] = 0;
        if (array == null || array.length == 0)
            return;
        int num = 0 ; //用于保存异或结果
        for (int i = 0; i < array.length; i++) {
            num = num ^ array[i];
        }
        int index = 0 ; //记录全异或后最右边为1 的位数。
        while ((num & 1) == 0 && index < Integer.SIZE) {//整数最大为32位。
            index ++;
            num = num >> 1;
        }
        for (int i = 0; i < array.length; i++) {
            if (isSubArray1(array[i],index))
                num1[0] = num1[0] ^ array[i];
            else
                num2[0] = num2[0] ^ array[i];
        }
    }
    public static boolean isSubArray1(int number, int index){
         for (int i = 0 ; i < index ; i++) {
             number = number >> 1;
         }
         return (number & 1) == 1;
    }
    public static void main (String[] args) {
        int[] array = new int[] {2,4,3,6,3,2,5,5};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        findNumsAppearOnce(array,num1,num2);
        System.out.println("the two numbers which appears once is: "+num1[0]+" and "+num2[0]);
    }
}
