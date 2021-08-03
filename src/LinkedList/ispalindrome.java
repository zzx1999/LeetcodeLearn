package LinkedList;

public class ispalindrome {
    ListNode left;
    public boolean isPalindrome(ListNode head) {
        //后续遍历
//        left = head;
//        return traverse(head);

        //优化空间复杂度
        left = head;
        ListNode slow = head,fast = head;
        //使用快慢指针找中点,slow走一步时fast走两步
        while (fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //slow指向链表中点
        if(fast!=null)
            slow = slow.next;
        ListNode right = reverse(slow);
        while (right!=null){
            if(left.val!=right.val)
                return false;
            left = left.next;
            right = right.next;
        }
        return true;

    }
    public boolean traverse(ListNode right){
        if(right==null) return true;
        boolean res = traverse(right.next);
        res = res && (left.val==right.val);
        left = left.next;
        return res;
    }
    //优化空间复杂度
    public ListNode reverse(ListNode head){
        ListNode cur,pre,nxt;
        cur = head;
        pre = null;
        while (cur!=null){
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
}
