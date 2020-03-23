//Given a linked list, remove the n-th node from the end of list and return its head.
//
//        Example:
//
//        Given linked list: 1->2->3->4->5, and n = 2.
//
//        After removing the second node from the end, the linked list becomes 1->2->3->5.
//        Note:
//
//        Given n will always be valid.
//
//        Follow up:
//
//        Could you do this in one pass?

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        int i = 0;

        // Move p2 n steps ahead
        while (i < n) {
            p2 = p2.next;
            i++;
        }

        // Now, move both p1 and p2 equally until p2 is not null
        // Also, maintain previous of p1
        // Eventually when p2 is null, then p1 is at the node to be removed
        // i.e. nth node from end
        while(p2 != null) {
            prev = p1;
            p1 = p1.next;
            p2 = p2.next;
        }

        // Update the pointers by removing p1
        prev.next = p1.next;
        return dummyHead.next;
    }
}