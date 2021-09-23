package DoublePointer;

import LinkedList.ListNode;

public class mergeTwoListsoff25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null && l2 == null){
            return null;
        }
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        ListNode head = l1.val>l2.val?l2:l1;
        ListNode point = head;
        while (l1!=null&&l2!=null){
            ListNode next;
            if(l1.val>l2.val){
                point.next = l2;
                l2 = l2.next;
            }
            else{
                point.next = l1;
                l1 = l1.next;
            }
            point = point.next;
        }
        point.next = l1 !=null?l1:l2;
        return head;
    }
}
