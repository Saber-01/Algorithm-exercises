package binaryTreeExample;

import DataStructure.BinaryTreeNode;

public class BinaryTree {
    // 完全二叉树
    public static BinaryTreeNode complete_binary_tree() {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        root.right.left = new BinaryTreeNode(16);
        return root;
    }
    //满二叉树
    public static BinaryTreeNode full_binary_tree() {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        root.right.left = new BinaryTreeNode(16);
        root.right.right = new BinaryTreeNode(17);
        return root;
    }
    //只有一个节点的二叉树
    public static BinaryTreeNode one_node_binary_tree() {
        BinaryTreeNode root = new BinaryTreeNode(1);
        return root;
    }
    //所有节点都只有左子节点的二叉树
    public static BinaryTreeNode left_node_only_binary_tree() {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.left.left = new BinaryTreeNode(3);
        root.left.left.left = new BinaryTreeNode(4);
        return root;
    }
    //所有节点都只有右子节点的二叉树
    public static BinaryTreeNode right_node_only_binary_tree() {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.right = new BinaryTreeNode(2);
        root.right.right = new BinaryTreeNode(3);
        root.right.right.right = new BinaryTreeNode(4);
        return root;
    }
    //所有元素相等的二叉树
    public static BinaryTreeNode equal_node_binary_tree() {
        BinaryTreeNode root = new BinaryTreeNode(16);
        root.left = new BinaryTreeNode(16);
        root.right = new BinaryTreeNode(16);
        root.left.left = new BinaryTreeNode(16);
        root.right.left = new BinaryTreeNode(16);
        root.right.right = new BinaryTreeNode(16);
        return root;
    }
    // 完全二叉检索树
    public static BinaryTreeNode complete_binary_search_tree() {
        BinaryTreeNode root = new BinaryTreeNode(5);
        root.left = new BinaryTreeNode(3);
        root.right = new BinaryTreeNode(7);
        root.left.left = new BinaryTreeNode(2);
        root.left.right = new BinaryTreeNode(4);
        root.right.left = new BinaryTreeNode(6);
        return root;
    }
    //满二叉检索树
    public static BinaryTreeNode full_binary_search_tree() {
        BinaryTreeNode root = new BinaryTreeNode(5);
        root.left = new BinaryTreeNode(3);
        root.right = new BinaryTreeNode(7);
        root.left.left = new BinaryTreeNode(2);
        root.left.right = new BinaryTreeNode(4);
        root.right.left = new BinaryTreeNode(6);
        root.right.right = new BinaryTreeNode(8);
        return root;
    }
    //只有一个节点的二叉检索树
    public static BinaryTreeNode one_node_binary_search_tree() {
        BinaryTreeNode root = new BinaryTreeNode(1);
        return root;
    }
    //所有节点都只有左子节点的二叉检索树
    public static BinaryTreeNode left_node_only_binary_search_tree() {
        BinaryTreeNode root = new BinaryTreeNode(4);
        root.left = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(2);
        root.left.left.left = new BinaryTreeNode(1);
        return root;
    }
    //所有节点都只有右子节点的二叉检索树
    public static BinaryTreeNode right_node_only_binary_search_tree() {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.right = new BinaryTreeNode(2);
        root.right.right = new BinaryTreeNode(3);
        root.right.right.right = new BinaryTreeNode(5);
        return root;
    }

    //节点包含一个指向父节点的指针的二叉树
    public static BinaryTreeNode includeParentPointBinaryTree(){
        BinaryTreeNode root=new BinaryTreeNode(1);
        root.left=new BinaryTreeNode(2);
        root.left.parent=root;
        root.left.left=new BinaryTreeNode(4);
        root.left.right=new BinaryTreeNode(5);
        root.left.left.parent=root.left;
        root.left.right.parent=root.left;
        root.right=new BinaryTreeNode(3);
        root.right.parent=root;
        root.right.left=new BinaryTreeNode(6);
        root.right.right=new BinaryTreeNode(7);
        root.right.left.parent=root.right;
        root.right.right.parent=root.right;
        return root;
    }
}
