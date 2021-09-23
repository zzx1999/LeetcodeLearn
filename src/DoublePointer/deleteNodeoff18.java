package DoublePointer;

import LinkedList.ListNode;

import javax.swing.event.ListDataEvent;

public class deleteNodeoff18 {
    public ListNode deleteNode(ListNode head, int val) {
        if(head.val == val)
            return head.next;
        ListNode pre = head, cur = head.next;
        while (cur!=null&&cur.val!=val){
            cur = cur.next;
            pre = pre.next;
        }
        if(cur!=null&&cur.val==val){
            pre.next = cur.next;
            cur.next = null;
        }
        return head;
    }
}
