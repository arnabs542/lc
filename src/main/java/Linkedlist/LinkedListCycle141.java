package Linkedlist;


import java.util.List;

/**
 * Created by yuehu on 5/13/19.
 * 141. Linked List Cycle
 * Given a linked list, determine if it has a cycle in it
 * time: O(n)
 * space: O(1q)
 */
public class LinkedListCycle141 {
    public static boolean hasCycle(ListNode head) {
       if(head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true;
            }
        }
        return false;
    }
}

