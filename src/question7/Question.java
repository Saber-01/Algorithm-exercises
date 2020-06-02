package question7;

import java.util.Scanner;

public class Question {
    public  static BinaryTreeNode Construct(int[] preOrder, int[] inOrder){
        if(preOrder==null||inOrder==null){
            System.out.print("输入的序列存在问题");
            return null;
        }
        else{//先定义初始输入的两个序列的范围，因为为了不改变序列结构以及不使用额外数组。所以使用角标来递归。
            int preOrderLeft=0;
            int preOrderRight=preOrder.length-1;
            int inOrderLeft=0;
            int inOrderRight=inOrder.length-1;
            return ConstructCore(preOrder,inOrder,preOrderLeft,preOrderRight,inOrderLeft,inOrderRight);
        }
    }
//这边思考如果不传递 前中序两个数组，能否直接使用变量名获得到对应数组呢？数组的作用范围和如何存储值得思考。
    public static BinaryTreeNode ConstructCore(int[] preOrder,int[] inOrder,int preOrderLeft,int preOrderRight,int inOrderLeft,int inOrderRight){
            BinaryTreeNode n=new BinaryTreeNode();
            n.m_nValue=preOrder[preOrderLeft];//前序遍历的第一个值肯定为这个当树（或子树）的根节点；
            n.m_pLeft=null;//初始赋值为null；
            n.m_pRight=null;
            //为了找出左右子树的分界点，需要找到根节点在中序遍历中的位置，其左右序列对应其左右子树序列
            if(preOrderLeft==preOrderRight){//叶节点
                return n;
            }
            int separatePoint =inOrderLeft;//初始化分界点为当前树的中序序列起点
            for(int i=inOrderLeft;i<inOrder.length;i++){
                if(inOrder[i]==n.m_nValue){
                    separatePoint=i;//找到根节点值时，赋值角标
                    break;
                }
            }
            int leftTreeLength=separatePoint-inOrderLeft;//左边子树个数
            int rightTreeLength=inOrderRight-separatePoint;//右边子树个数
            int leftSubTreeInOrderLeft=0;//左子树中序序列左边界
            int leftSubTreeInOrderRight=0;//左子树中序序列右边界
            int rightSubTreeInOrderLeft=0;//右子树中序左边界
            int rightSubTreeInOrderRight=0;//同上 顾名思义。
            int leftSubTreePreOrderLeft=0;
            int leftSubTreePreOrderRight=0;
            int rightSubTreePreOrderLeft=0;
            int rightSubTreePreOrderRight=0;
            if(leftTreeLength==0){//没有左子树
                n.m_pLeft=null;
            }
            else{
                leftSubTreeInOrderLeft=inOrderLeft;//中序遍历左右由这个节点分开。
                leftSubTreeInOrderRight=separatePoint-1;
                leftSubTreePreOrderLeft=preOrderLeft+1;//下一个左子树前序遍历序列起点要+1跳过序列第一个根节点；
                leftSubTreePreOrderRight=leftSubTreePreOrderLeft+leftTreeLength-1;//右边界需要用左边界加上子树点个数减1
                n.m_pLeft=ConstructCore(preOrder,inOrder,leftSubTreePreOrderLeft,leftSubTreePreOrderRight,leftSubTreeInOrderLeft,leftSubTreeInOrderRight);
            }
            if(rightTreeLength==0){//没有右子树
                n.m_pRight=null;
            }
            else{
                rightSubTreeInOrderLeft=separatePoint+1;//右子树中序序列左边界为分界点往后一个
                rightSubTreeInOrderRight=inOrderRight;//右子树中序序列右边界为输入的原中序右边界
                rightSubTreePreOrderLeft=preOrderLeft+leftTreeLength+1;//右子树前序序列左边界为原来的左边界加上左子树点数再往后一格，因为要跳过开头的节点。
                rightSubTreePreOrderRight=preOrderRight;//右子树前序序列右边界就是原来的输入的前序遍历右边界
                n.m_pRight=ConstructCore(preOrder,inOrder,rightSubTreePreOrderLeft,rightSubTreePreOrderRight,rightSubTreeInOrderLeft,rightSubTreeInOrderRight);
            }
            return n;
    }
    public static void BinaryTreePrintPreOrder(BinaryTreeNode root){
        System.out.print(root.m_nValue+"，");
        if(root.m_pLeft!=null){
            BinaryTreePrintPreOrder(root.m_pLeft);
        }
        if(root.m_pRight!=null)
        {
            BinaryTreePrintPreOrder(root.m_pRight);
        }
    }
    public static void main(String[] args){
        System.out.printf("输入树的前序遍历 ,逗号隔开，回车结束");
        Scanner input=new Scanner(System.in);
        String str=input.nextLine();
        String[] strArray=str.trim().split(",");
        int[] preOrder=new int[strArray.length];
        for(int i=0;i<preOrder.length;i++){
            preOrder[i]=Integer.parseInt(strArray[i]);
        }
        System.out.printf("输入树的中序遍历 ,逗号隔开，回车结束");
        String str2=input.nextLine();
        String[] strArray2=str2.trim().split(",");
        int[] inOrder=new int[strArray2.length];
        for(int i=0;i<inOrder.length;i++){
            inOrder[i]=Integer.parseInt(strArray2[i]);
        }
//        for(int c:preOrder){System.out.print(c);}
//        for(int c:inOrder){System.out.print(c);}
        BinaryTreeNode n=Construct(preOrder,inOrder);
        BinaryTreePrintPreOrder(n);
        System.out.print("根节点值为"+n.m_nValue);
    }
}
