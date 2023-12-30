package org.example.problems;

public class Partition86 {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode beforeHead = new ListNode(0);
        ListNode before = beforeHead;
        ListNode afterHead = new ListNode(0);
        ListNode after = afterHead;

        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }

        after.next = null; // Set the next of the last node to null to avoid cyclic linked list
        before.next = afterHead.next; // Connect the "before" list to the "after" list

        return beforeHead.next;
    }

}
