package question34;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import DataStructure.BinaryTreeNode;

public class Question {
    //因为题目中是从根节点到叶节点经过的所有的节点构成路径，所以考虑从根节点往下遍历的时候，同时累加经过的节点值，并且进行比较。
    //同时经过一个节点，就需要先累加判断，然后再考虑其子节点，所以遍历顺序和前序遍历相同，所以考虑前序遍历的思想。
    //只不过这边每次遍历到节点，就要将节点值加到其前面经过路径已经累加的值中去，所以需要定义一个变量，用于存储路径经过的节点累加的值。
    //当我们继续遍历到子节点时，需要将这个累加值也传入到下一个递归函数中，使问题转换成判断下一个节点值累加会不会等于目标值。
    //而当到达一个叶节点。即没有左右子节点时，进行判断。判断所累加的值是否等于这个目标值，如果等于，就要打印出这条路径。
    //打印时，因为节点不含有指向父节点的指针， 所以这要求我们每一步的遍历都需要把遍历的节点存储起来。
    //为了方便当遇到不满足条件节点时候，进行回到上个节点的操作，也就是将存的节点直接取出，后进先出的思想，所以考虑用栈来存。
    //即每一个节点需要做的是，判断累加值是否等于目标值，等于了并且是到了叶节点，就进行打印。。
    //如果累加值不满足，并且还未达到叶节点，则继续往下遍历，
    //在每一个节点处理函数中，处理完回退到上一步节点，就要进行一次弹出。
    public static void printPath(BinaryTreeNode root,int sum){
        if(root==null){
            System.out.println("输入的树为空");
            return;
        }
        Stack<Integer> stack=new Stack<>();
        int curSum=0;//初始的累加值
        printPathCore(root,sum,stack,curSum);
    }
    public static void printPathCore(BinaryTreeNode root,int sum,Stack<Integer> stack,int curSum){
        curSum=curSum+root.val;//当前累加值加上遍历到的节点的值。
        stack.push(root.val);//把遍历到的节点存入到栈中保存，用于打印路径需要。
        boolean isLeaf=true;
        if(root.left!=null||root.right!=null)//存在任意一个子节点，就说明不是叶节点。
            isLeaf=false;
        if(isLeaf&&curSum==sum){//到达叶节点，并且累加值满足目标值，则要进行打印。
            List<Integer> array=new ArrayList<>(stack);//因为打印时候，不能改变stack的内部值，所以新建列表进行打印
            System.out.print("发现路劲：");
            for(int c:array)
                System.out.print("-->"+c);
            System.out.println();//打印一个路径后换行
        }
        if(root.left!=null)//当他不是叶节点时候，要继续遍历，
            printPathCore(root.left,sum,stack,curSum);
        if(root.right!=null)
            printPathCore(root.right,sum,stack,curSum);

        stack.pop();//已经遍历完该节点的子节点，或者已经到根节点，就要进行，回退，回退一个节点，显然要弹出栈。
    }
    public static void main(String[] args){
        BinaryTreeNode root=new BinaryTreeNode(10);
        root.left=new BinaryTreeNode(5);
        root.right=new BinaryTreeNode(12);
        root.left.left=new BinaryTreeNode(4);
        root.left.right=new BinaryTreeNode(7);
        System.out.println("输入目标路径和，输出为二叉树和为该整数的路径：");
        Scanner scan=new Scanner(System.in);
        int sum=0;
        if(scan.hasNextInt()){
            sum=scan.nextInt();
        }
        else{
            System.out.println("输入整数有误");
            return;
        }
        printPath(root,sum);
    }
}
