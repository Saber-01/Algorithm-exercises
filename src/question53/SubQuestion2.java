package question53;

public class SubQuestion2 {
    public static int findNumberSameAsIndex(int[] array) {
        if (array == null || array.length == 0) {
            System.out.println("the input array is null");
            return -1;
        }
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int middle = (start + end) >> 1;
            if (array[middle] == middle)
                return middle;
            else if (array[middle] < middle)//数值小于角标，因为是递增数组，所以目标值只可能出现在middle右边
                start = middle + 1;
            else
                end = middle - 1 ;
        }
        return  -1;
    }
    public static void main (String[] args) {
        int[] array = new int[] {-3,-1,1,3,5};
        System.out.println(findNumberSameAsIndex(array));
    }
}
