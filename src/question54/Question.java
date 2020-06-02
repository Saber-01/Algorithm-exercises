package question54;
import DataStructure.BinaryTreeNode;
import binaryTreeExample.BinaryTree;

import java.util.Scanner;

public class Question {
    static int index = 0;
    public static BinaryTreeNode findTheKthOfBinarySearchTree(BinaryTreeNode root, int k) {
        if (root == null || k <=0 ) {
            System.out.println("input has error");
            return null;
        }
        return findTheKthOfBinarySearchTreeCore(root,k);
    }

    public static BinaryTreeNode findTheKthOfBinarySearchTreeCore(BinaryTreeNode root, int k) {
        BinaryTreeNode result = null;
        if (root.left != null) { //有左子树，先判断
             result = findTheKthOfBinarySearchTreeCore(root.left,k);
        }
        if(result == null) {
            index ++;
            if (index == k)
                result = root;
        }
        if (result == null && root.right != null) {
            result = findTheKthOfBinarySearchTreeCore(root.right,k);
        }
        return  result;
    }
    public static void main (String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(5);
        root.left = new BinaryTreeNode(3);
        root.right = new BinaryTreeNode(7);
        root.left.left = new BinaryTreeNode(2);
        root.left.right = new BinaryTreeNode(4);
        root.right.left = new BinaryTreeNode(6);
        root.right.right = new BinaryTreeNode(8);
        System.out.println("input the k ");
        Scanner scan = new Scanner(System.in);
        int k = 0 ;
        if (scan.hasNextInt()) {
            k = scan.nextInt();
        }
        System.out.println("the kth number of the BinarySearchTree is"+findTheKthOfBinarySearchTree(root,k).val);
    }
}
