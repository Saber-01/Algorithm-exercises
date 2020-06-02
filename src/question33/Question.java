package question33;

import java.util.Scanner;

public class Question {
    //分析，后序遍历的序列中，最后一个值肯定是根节点。且因为是二叉搜索树，可知，根节点的左子树的节点应该值都比根节点小，且位于序列左侧。
    //根节点的右子树的节点值都比根节点大。且位于序列右侧。则说明这个序列在根节点处是满足左右子树小于和大于的关系的。
    //但是对于上一步区分出来的序列左侧的比根节点小的子序列其实是左子树，易知左子树也是二叉搜索树，所以可以递归判断新的问题。
    //对于右侧大的子序列也可以看成右子树的序列。那么问题就变成，左右子树的2个子序列是否是二叉搜索树的后序遍历。就可以递归判断了
    //终止条件就是在问题的分解过程中判断到不满足，就返回，或者直到子问题变成规模是2个节点以下的，就返回true。因为后序遍历2个节点无论排列如何，都满足。
    public static boolean isPostOrderOfBST(int[] postOrder){
        if(postOrder.length==0||postOrder==null){
            System.out.println("输入的序列为空");
            return  false;
        }
        return isPostOrderOfBSTCore(postOrder,0,postOrder.length-1);//初始为整个数组的0到length-1 范围传入。
    }
    public static boolean isPostOrderOfBSTCore(int[] postOrder,int begin,int end){
        if(end-begin<=1){//小于1，即子序列小于2个，该子序列满足。返回true
            return true;
        }
        //以下开始为序列长度大于2的情况。
        int rootValue=postOrder[end];//将序列最后的值取出，存起来用于比较区分左右子树。
        int point=begin;
        while(point<end&&postOrder[point]<rootValue){//判断多少个节点属于左子树。
            point++;
        }
        //左子树在遇到点值大于根值时停止，这是剩下序列的值应该全大于根值，否则不存在这样二叉搜索树，直接返回false.
        for(int i=point;i<end;i++){//判断剩下序列点值是否都满足。
            if(postOrder[i]<rootValue)
                return false;
        }
        return  isPostOrderOfBSTCore(postOrder,begin,point-1)&&isPostOrderOfBSTCore(postOrder,point,end-1);
    }
    public static void main(String[] args){
        System.out.println("输入整数数组，数组的任意两个要求不相同，逗号隔开，换行结束");
        Scanner scan =new Scanner(System.in);
        String temp=scan.nextLine();
        String[] str=temp.trim().split(",");
        int[] postOrder=new int[str.length];
        try{
            for(int i=0;i<postOrder.length;i++){
                postOrder[i]=Integer.parseInt(str[i]);
            }
        }catch (Exception e){
            System.out.print("输入的序列出错");
            postOrder=null;
            return;
        }
        if(isPostOrderOfBST(postOrder)){
            System.out.println("输入的序列是二叉搜索树的的后序遍历序列");
        }
        else
            System.out.println("输入的序列不是某二叉搜索树的后序遍历序列");
    }
}
