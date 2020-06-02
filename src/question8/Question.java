package question8;

import DataStructure.BinaryTreeNode;
import binaryTreeExample.BinaryTree;

public class Question {
    public static int InOrderNextPointOfBinaryTree(BinaryTreeNode root,BinaryTreeNode node){//输入为一个二叉树，和任一个节点，需要返回下个中序遍历的值
        if(root==null){
            System.out.print("输入的二叉树为空");
            return 0;
        }
        else {
            BinaryTreeNode nextNode=new BinaryTreeNode(0);//初始化用于存放下一个节点的变量；
            if(node.right!=null)//如果这个节点存在右子树，则从右子树中找下个节点；
            {
                nextNode=node.right;//初始指向当前节点的右子树的根节点；
                while(nextNode.left!=null){//如果下个节点有左子节点，那么需要继续往下查找
                        nextNode=nextNode.left;
                    }
                return nextNode.val;//找到后返回值
            }
            else{//则不存在右子树，则需要从其父节点开始去寻找。
                if(node.parent==null)//说明该节点是父节点，且他没有右子树，则该点就是最后一个中序遍历点
                {
                    System.out.print("该节点就是中序遍历的最后一个节点");
                    return 0;
                }
                else//该节点不是父节点且没右子树。
                {
                    nextNode=node;//因为下个节点
                    while(nextNode.parent!=null&&nextNode.parent.right==nextNode){//如果还满足这个循环，说明遍历到的这个节点要么是根节点，要么这个点是其父节点的左子节点。
                        nextNode=nextNode.parent;
                    }
                    if(nextNode.parent==null)//说明是遍历到根节点退出
                    {
                        System.out.print("该节点就是中序遍历的最后一个节点");
                        return 0;
                    }
                    else{//说明是因为找到了自己是父节点的左子数根节点的父节点。即该父节点就是下一个中序遍历的输出。
                        return nextNode.parent.val;
                    }
                }
            }
        }
    }
    public static void BinaryTreeInOrderPrint(BinaryTreeNode root){
        if(root!=null){
            if(root.left!=null){
                BinaryTreeInOrderPrint(root.left);
            }
            System.out.print(root.val);
            if(root.right!=null){
                BinaryTreeInOrderPrint(root.right);
            }
        }
    }
    public static void main(String[] args){
        BinaryTreeNode root=BinaryTree.includeParentPointBinaryTree();//调用方法获得测试的树
        BinaryTreeNode node=root.left.right;
        System.out.print("输入树的中序遍历序列为：");
        BinaryTreeInOrderPrint(root);
        System.out.print("要找的节点的值为："+node.val);
        int a=InOrderNextPointOfBinaryTree(root,node);
        if(a!=0){
            System.out.print("下一个中序遍历节点是"+a);
        }
    }
}
