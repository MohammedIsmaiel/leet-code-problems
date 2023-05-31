package org.example.problems;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode tempNode = head;
        ListNode lastNode = new ListNode();
        ListNode firstNodeAfterRotate = new ListNode();
        ListNode lastNodeAfterRotate = new ListNode();
        int length = 1;
        while (tempNode.next != null) {
            tempNode = tempNode.next;
            lastNode = tempNode;
            length++;
        }
        var timeToRotate = k % length;
        if (timeToRotate == 0)
            return head;
        tempNode = head;

        for (int i = 1; i <= length - timeToRotate; i++) {
            lastNodeAfterRotate = tempNode;
            firstNodeAfterRotate = tempNode.next;
            tempNode = tempNode.next;
        }
        lastNode.next = head;
        lastNodeAfterRotate.next = null;
        return firstNodeAfterRotate;
    }
}
// while (tempNode.next.next != null) {
// tempNode = tempNode.next;
// lastNode = tempNode.next;
// if (length == timeToRotate - 1)

// lastNodeAfterRotate = tempNode;
// if (length == timeToRotate)
// firstNodeAfterRotate = tempNode;
// length++;
// }
