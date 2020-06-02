package question32;

import DataStructure.BinaryTreeNode;

import java.util.Stack;

public class Sub2Quetion {
    //逐行分析，首先第一行，打印出根节点时候，需要存它的子节点到容器中，注意到第三行，当处理第二行时候，先打印出来的两个孩子节点在下一行中确实靠后打印的，
    //最新打印出来的节点，在下一行打印的时候是最先被打印的。这就是像后进去的先出去，所以我们可以使用栈来实现。
    //所以第二行也是用栈来实现。要注意这两个栈必须独立，因为当一个行处理没结束时，加入子节点，下一步弹出的就是新加入的。必不可能是当层节点。所以需要2个栈
    //注意到奇数行是从左到右打印，偶数行是从右到左打印。所以。在奇数行处理子节点时，每个节点的左节点应该比右节点先存。
    //同样在偶数行处理节点时候，因为下一行是从左到右，所以，每个节点处理时候，它的右节点应该比左节点先存入栈。因为栈是先入后出的。
    //终止条件就是2个栈都为空的时候。
    public static void print(BinaryTreeNode root) {
        if (root == null) {
            System.out.println("输入的二叉树为空");
            return;
        }
        Stack<BinaryTreeNode> stack1 = new Stack<>();//申请两个栈 stack1记录奇数行。
        Stack<BinaryTreeNode> stack2 = new Stack<>();//记录偶数行
        int column = 1;//记录奇偶行。只可能是两个值，1代表奇数，0代表偶数。从第一行开始所以初始是奇数
        stack1.push(root);//先入根节点
        while (!stack1.empty() || !stack2.empty()) {//任意一个不为空说明都没结束。
            if (column == 1) {//如果当前打印的是奇数行。
                BinaryTreeNode node = stack1.pop();//栈1存奇数行点
                System.out.print(" " + node.val);
                if (node.left != null)
                    stack2.push(node.left);
                if (node.right != null)
                    stack2.push(node.right);
            } else if (column == 0) {//当前打印的是偶数行
                BinaryTreeNode node = stack2.pop();//栈2 中存偶数行点
                System.out.print(" " + node.val);
                if (node.right != null)  //从右开始存
                    stack1.push(node.right);
                if (node.left != null)
                    stack1.push(node.left);
            }
            if (stack1.empty() && column == 1) {//正在打印奇数行的时候，发现栈1 刚好结束。说明奇数行结束
                System.out.println();//先换行
                column = 0;//变为偶数行
            } else if (stack2.empty() && column == 0) {//正在打印奇数行的时候，发现栈2为空，说明偶数行结束
                System.out.println();//先换行
                column = 1;//变为奇数行
            }
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(8);
        root.left = new BinaryTreeNode(6);
        root.right = new BinaryTreeNode(10);
        root.left.left = new BinaryTreeNode(5);
        root.left.right = new BinaryTreeNode(7);
        root.right.left = new BinaryTreeNode(9);
        root.right.right = new BinaryTreeNode(11);
        System.out.println("从上到下Z字形打印二叉树的序列为：");
        print(root);
    }
}
