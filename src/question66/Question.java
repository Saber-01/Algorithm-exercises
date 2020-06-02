package question66;

public class Question {
    //不用除法求乘积数组。A[0-n-1]求B[0-n-1],B[i]=A[0]*..A[i-1]*A[i+1]*A[n-1];
    //如果常规解法，就是每个遍历，每个累乘就行。但是发现很多是重复计算
    //观察到从0到i，左半部分A[0]~A[i-1]，其实只是每次多乘一个A[i-1]，
    //而同样，右边是每次少乘一个A[i+1];
    //因此左半部分可以先自上而下分别求出记录为C[0~n-1]，其中C[i]=A[0]*A[1]*.....*A[i-1]，C[i]=C[i-1]*A[i-1];
    //右半部分可以自下而上分别求出D[0~n-1],其中D[i]= A[n-1]*A[n-2]*.....*A[i+1];D[i]= D[i+1]*A[i+1];
    //最后B[i]= C[i]*D[i];
    //我们可以首先自上而下，将C[i]保存到B[i]中。
    //然后在自下而上，先赋值B[n-1]=B[n-1]*1，再是B[n-2]=B[n-2]*A[n-1],这时需要将A[n-1]保存到temp中，用于下次累乘。
    public static int[] multiply(int[] A) {
        if (A.length <= 1) {
            return A;
        }
        int[] B = new int[A.length];
        B[0] = 1;
        for (int i = 1; i < B.length; i++) {
            B[i] = B[i-1] * A[i-1];
        }
        int temp = 1;
        for (int j = A.length - 1; j >= 0; j--) {
            B[j] = B[j] * temp;
            temp = temp * A[j];//temp = D[j+1]*A[j+1];//因为这个temp是在下一次循环用的。
        }
        return B;
    }
    public static void main(String[] args) {
        int[] A = new int[] {1,2,3,4,5};
        int[] B =multiply(A);
        for (int i = 0; i < B.length; i++) {
            System.out.print(B[i]+" ");
        }
    }
}
