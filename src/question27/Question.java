package question27;
import DataStructure.BinaryTreeNode;
public class Question {
    public static void printBinaryTree(BinaryTreeNode root){
        System.out.print(" "+root.val);
        if(root.left!=null){
            printBinaryTree(root.left);
        }
        if(root.right!=null){
            printBinaryTree(root.right);
        }
    }
    //画图举例，对比发现，镜像，其实就是把每个左右节点都互换，然后这个节点以下的孩子节点也是要经过其左右子节点交换，所以可以看成是子问题。则可以用递归。
    //只要最底下叶节点交换完毕，说明子树完毕，返回这个节点到上层进行，交换操作。直到到根节点，进行返回。

    public static BinaryTreeNode mirrorOfBinaryTree(BinaryTreeNode root){
        if(root==null){
            return null;
        }
        BinaryTreeNode root1=new BinaryTreeNode(root.val);
        root1.left=mirrorOfBinaryTree(root.right);
        root1.right=mirrorOfBinaryTree(root.left);
        return root1;
    }
    public static void main(String[] args){
        BinaryTreeNode root=new BinaryTreeNode(8);
        root.left=new BinaryTreeNode(6);
        root.right=new BinaryTreeNode(10);
        root.left.left=new BinaryTreeNode(5);
        root.left.right=new BinaryTreeNode(7);
        root.right.left=new BinaryTreeNode(9);
        root.right.right=new BinaryTreeNode(11);
        printBinaryTree(root);
        System.out.print("翻转后的镜像二叉树的前序遍历序列为：");
        printBinaryTree(mirrorOfBinaryTree(root));

    }
}
