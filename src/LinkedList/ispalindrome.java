package LinkedList;

public class ispalindrome {
    ListNode left;
    public boolean isPalindrome(ListNode head) {
        //��������
//        left = head;
//        return traverse(head);

        //�Ż��ռ临�Ӷ�
        left = head;
        ListNode slow = head,fast = head;
        //ʹ�ÿ���ָ�����е�,slow��һ��ʱfast������
        while (fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //slowָ�������е�
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
    //�Ż��ռ临�Ӷ�
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
