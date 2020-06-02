package question32;
import DataStructure.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Question {
    //分析，需要从根节点开始打印，打印后，需要分别打印它的左子节点和右子节点。
    //而当打印它的左子节点和右子节点以后，每个子节点又需要打印它们自己的孩子节点。
    //并且可以反向打印是从上到下，从左到右的。所以当一层结束了打印，还需要按照这一层父节点打印的顺序，答应它们的孩子节点。
    //也就是谁先打印，则它的孩子节点也要先打印，但是孩子节点打印时候，需要这层的其他节点都打印完。所以我们不能一口气从一个节点直接遍历到最下层
    //我们需要把当前层的节点记录下来。当这个节点，被打印时候，就将它的孩子节点按左右顺序放入到当前层的节点之后。
    //然后打印下一个当层节点，也将这个节点的孩子节点存入到刚才打印的上个节点的孩子节点的后面，对当前层每个节点这么操作。
    //那么当这一层结束以后，发现存入的顺序刚好就是下一层从左到右的顺序。因此这里面的先存的先打印的思想和队列是一样的
    //所以我们可以使用队列来实现。首先存入根节点。每个节点出对列的时候，做两件事。
    //第一件是将这个节点值答应出来。第二件是将他的孩子节点按左右顺序放入队列后。
    //打印的结束条件应该是队列为空的情况。
    public static void printFromTopToBottom(BinaryTreeNode root){
        if(root==null){
            System.out.println("输入的二叉树为空");
            return;
        }
        Queue<BinaryTreeNode> queue=new LinkedList<>();
        queue.offer(root);//先把根节点入队列。
        while(!queue.isEmpty()){//不为空就继续
            BinaryTreeNode node=queue.poll();//弹出队列首部的值
            System.out.print(" "+node.val);//第一件是打印
            if(node.left!=null)//第二件事是判断其孩子节点
                queue.offer(node.left);
            if(node.right!=null)
                queue.offer(node.right);
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
        printFromTopToBottom(root);
    }
}
