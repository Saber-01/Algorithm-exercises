package question32;

import DataStructure.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;
//变题是说每一层要换行，即我们可以从一开始就记录每一行的个数，并且在处理当前层的时候，要记录下一层要打印几个，从而在换行时候赋值给记录当前要处理的个数。一直循环到队列无值
//这就需要两个变量，curLevelLeftCount是记录要答应当前层还剩几个没有打印，另一个nextLevelCount是在处理当前层时，记录下一层要打印的总数。
//当处理当前层时，在弹出一个就打印一个，curLevelLeftCount就减1，同时， 在判断其子节点时候，不管是左节点还是右节点，存在并入队列，nextLevelCount就加1。
//当curLevelLeftCount=0时,这是需要先换行。然后把nextLevelCount中记录的下一层节点总数赋值给curLevelLeftCount,并且nextLevelCount重置为0，开始新一行的记数。
public class Sub1Question {
    public static void printFromTopToBottomLn(BinaryTreeNode root){
        if(root==null){
            System.out.println("输入的二叉树为空");
            return;
        }
        Queue<BinaryTreeNode> queue=new LinkedList<>();
        queue.offer(root);//先把根节点入队列。
        int nextLevelCount=0;//下一层要打印的个数
        int curLevelLeftCount=1;//当前层还没打印的，初始为1.即根节点。
        while(!queue.isEmpty()){//不为空就继续
            BinaryTreeNode node=queue.poll();//弹出队列首部的值
            System.out.print(" "+node.val);//第一件是打印
            curLevelLeftCount--;//打印以后，当前层的剩下个数减1;
            if(node.left!=null)//第二件事是判断其孩子节点
            {
                queue.offer(node.left);//如果有左子节点，入队列
                nextLevelCount++;//下一层个数+1;
            }
            if(node.right!=null){
                queue.offer(node.right);
                nextLevelCount++;//同样有右子节点入队列，下一层个数也加1；
            }
            if(curLevelLeftCount==0){//如果当前，说明这一层打印完了。需要换行
                System.out.println(); //换行
                curLevelLeftCount=nextLevelCount;//当换行以后，当前行待打印的其实就是记录的下层要打印个数的nextLevelCount;
                nextLevelCount=0;//因为换行以后，统计新的一行要打印的个数时候，需要清空为0，从新记录。
            }
        }
    }
    public static void main(String[] args){
        BinaryTreeNode root=new BinaryTreeNode(8);
        root.left=new BinaryTreeNode(6);
        root.right=new BinaryTreeNode(10);
        root.left.left=new BinaryTreeNode(5);
        root.left.right=new BinaryTreeNode(7);
        root.right.left=new BinaryTreeNode(9);
        root.right.right=new BinaryTreeNode(11);
        System.out.println("从上到下打印二叉树的序列为：");
        printFromTopToBottomLn(root);
    }
}
