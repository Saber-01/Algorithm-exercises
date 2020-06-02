package question5;

import java.util.Scanner;

public class SubQuestion {
    public static int[] insert(int[] A1,int[] A2,int length){
        int p1=length-1;
        int p3=length+A2.length-1;
        int p2=A2.length-1;
        while(p2>=0&&p1>=0){
            if(A2[p2]>=A1[p1]){
                A1[p3--]=A2[p2--];
            }
            else
            {
                A1[p3--]=A1[p1--];
            }
        }
        if(p2<0)//说明A2全部插入了，那么直接输出
        {
            return A1;
        }
        else if(p1<0){//说明A1原来的数先移动完，则把A2的剩下全部塞到A1数组前半段去。
            while(p2>=0){
                A1[p3--]=A2[p2--];
            }
        }
        return A1;
    }
    public static void main(String[] args){
        int[] A1=new int[100];//按题目要求保证足够多的空间
        Scanner scan=new Scanner(System.in);
        int i=0;
        System.out.print("输入一个升序数组A1，空格隔开，末尾用#结束");
        while(scan.hasNextInt())//hasNextInt仅仅只是判断标记的是否为 int 类型的数据 ,并不会将标记移到下一行
        {
            A1[i]=scan.nextInt();
            i++;
        }
        scan.nextLine();//为了读取nextInt 留的空白
        System.out.print("输入一个升序数组A2，空格隔开，换行结束结束");
        Scanner scan1=new Scanner(System.in);
        String str=scan.nextLine();
      //  System.out.print(str);
        String[] strArray=str.trim().split(" ");
        int[] A2=new int[strArray.length];
        for(int j=0;j<A2.length;j++){
            A2[j]=Integer.parseInt(strArray[j]);
        }
        System.out.print("A2插入A1后的结果为");
        A1=insert(A1,A2,i);
        for(int c:A1){
            System.out.print(c);
        }
       // System.out.print(A1.length);
    }
}
//Scanner 。nextline 在nextint后面不生效的问题：
/*     然后，在Java中，Scanner就像是一个扫描器，它会从内存中的一块缓冲区中扫描并且读入数据
，而这个Scanner扫描器在扫描过程中判断停止扫描的依据是“空白符”（即空格或者回车之类的空白符号）。
实际上 nextInt()方法的运行原理是在扫描到“空白符”的时候，Scanner会把“空白符”前面的数据读取走并且在缓冲区中遗留一个空白符“\r”。
而nextLine() 方法的运行原理则是会把空白符好一同读取。
明白nextInt() 方法以及nextLine() 方法的运行原理之后，就不难理解为什么在使用nextInt()之后无法使用nextLine()的问题了。
因为，当nextInt()运行结束后，缓冲区会遗留一个空白符号，而后到nextLine()运行的时候，则会把这个空白符号读取进去，而Scanner因为扫描到空白符，判定扫描结束，
所以，会出现使用nextInt()之后nextLine()无法运行的现象。实际上，nextLine()并非没有运行，而是已经结束了运行。
因此要解决这个问题，可以在要运行的nextLine()方法之前添加多一条nextLine()语句，已读取nextInt()遗留的空白符。或者，采用next()方法来代替。*/