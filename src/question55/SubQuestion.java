package question55;

import DataStructure.BinaryTreeNode;

public class SubQuestion {
    static boolean isBalance = true;
    public static boolean isBalanced(BinaryTreeNode root) {
        checkDepth(root);
        return isBalance;
    }
    public static int checkDepth(BinaryTreeNode root) {
        if  (root ==null)
            return 0;
        int left = checkDepth(root.left);
        int right =checkDepth(root.right);
        if (left-right > 1 || left-right < -1)
            isBalance =false;
        return Math.max(left,right)+1;
    }
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        root .left.right.left = new BinaryTreeNode(7);
        root.right.right = new BinaryTreeNode(6);
        if (isBalanced(root)) {
            System.out.println("the BinaryTree is balanced");
        }
        else
            System.out.println("the BinaryTree is not balanced");
    }
}
