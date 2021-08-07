package LinkedList;

public class cyclecheck {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head,fast = null;
        if(slow==null||slow.next == null)
            return false;
        else
            fast = slow.next.next;
        while (slow!=fast){
            if(fast==null||fast.next==null)
                return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;


    }
}
