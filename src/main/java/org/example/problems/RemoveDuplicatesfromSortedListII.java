package org.example.problems;

public class RemoveDuplicatesfromSortedListII {
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        while (curr != null) {
            if (curr.next != null && curr.val == curr.next.val) {
                while (curr.next != null && curr.val == curr.next.val)
                    curr = curr.next;
                prev.next = curr.next;
            } else
                prev = prev.next;
            curr = curr.next;
        }
        return dummy.next;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        while (curr != null) {
            if (curr.next != null && curr.val == curr.next.val) {
                int duplicateValue = curr.val;
                ListNode nextDistinctNode = curr.next.next;
                while (nextDistinctNode != null && nextDistinctNode.val == duplicateValue)
                    nextDistinctNode = nextDistinctNode.next;
                prev.next = nextDistinctNode;
                curr = nextDistinctNode;
            } else {
                prev = prev.next;
                curr = curr.next;
            }
        }
        return dummy.next;
    }

}
