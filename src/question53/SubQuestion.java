package question53;

public class SubQuestion {
    public static int findTheLoseNumber(int[] array) {
        if (array == null || array.length == 0) {
            System.out.println("the array is null");
            return -1;
        }
        int start = 0 ;
        int end = array.length - 1 ;
        while (start <= end) {
            int middle = (start + end) >> 1;
            if (array[middle] != middle) { //出现不相等，要判断是否是第一个出现。
                if (middle > 0 && array[middle - 1] == middle - 1 || middle == 0) {//第一个出现
                    return middle;
                }
                else
                    end = middle - 1;
            }
            else {//若等于，则说明。左半部分要舍弃。
                start = middle + 1 ;
            }
        }
        if (start == array.length) //***重要****如果遍历到最后还是都是满足，说明少了最后一个值 n.
            return array.length;
        return  -1 ;
    }

    public static void main (String[] args) {
        int[] array = new int[] {0,1};
        System.out.println("the lose number is" +findTheLoseNumber(array));
    }
}
