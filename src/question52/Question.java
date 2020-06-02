package question52;
import DataStructure.ListNode;

public class Question {
    //寻找链表第一个公共节点，可知，2个链表在出现公共节点后，后面节点应该都相同。
    //所以可以全部遍历，计算出2个链表的长度差，
    //而后先将长链表遍历这个长度差，然后第二个链表也开始同时遍历。
    //这样每次判断遍历到的节点，如果相同，则说明出现了第一个相同节点。
    public static ListNode findFirstCommonListNode(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            System.out.println("the ListNode is null");
            return null;
        }
        int lenth1 = getListLength(head1);
        int lenth2 = getListLength(head2);
        int distance = lenth1 - lenth2;
        ListNode longListPoint = head1;
        ListNode shortListPoint = head2;
        if (lenth1 < lenth2) {
            distance = lenth2 - lenth1;
            longListPoint = head2;
            shortListPoint = head1;
        }
        for (int i = 0; i < distance; i++) {
            longListPoint = longListPoint.next;
        }
        while (longListPoint != null && shortListPoint != null && longListPoint != shortListPoint) {
            longListPoint = longListPoint.next;
            shortListPoint = shortListPoint.next;
        }
        return longListPoint;
    }

    public static int getListLength(ListNode head) {
        int length = 0;
        ListNode curNode = head;
        while (curNode != null) {
            length++;
            curNode = curNode.next;
        }
        return  length;
    }
    public static void main (String[] args) {
        ListNode head1 = new ListNode(0);
        head1.next = new ListNode(0);
        head1.next.next = new ListNode(0);
        head1.next.next.next = new ListNode(0);
        head1.next.next.next.next = new ListNode(0);
        head1.next.next.next.next.next = new ListNode(0);
        ListNode head2 = new ListNode(9);
        head2.next = new ListNode(9);
        head2.next.next = new ListNode(9);
        ListNode publicNode = new ListNode(1);
        publicNode.next = new ListNode(2);
        publicNode.next.next = new ListNode(3);
        head2.next.next.next = publicNode;
        head1.next.next.next.next.next.next = publicNode;
        if (findFirstCommonListNode(head1,head2) == null)
            return;
        System.out.println(findFirstCommonListNode(head1,head2).value);
    }
}
