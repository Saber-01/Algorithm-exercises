package question55;
import DataStructure.BinaryTreeNode;

public class Question {
    public static int getBinaryTreeDepth(BinaryTreeNode root) {
        if (root == null)
            return 0;
        int left = getBinaryTreeDepth(root.left);//递归获得左子树深度
        int right = getBinaryTreeDepth(root.right);//递归获得右子树深度
        return Math.max(left,right)+1;//当前子树深度为左子树深度和右子树深度最大的一个+1；
    }
    public static void main (String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        root .left.right.left = new BinaryTreeNode(7);
        root.right.right = new BinaryTreeNode(6);
        System.out.println("the Depth of tree is"+getBinaryTreeDepth(root));
    }
}
