package LinkedList;

public class reverseKlink {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null)
            return null;
        //先找到区间a,b
        ListNode b = head;
        for(int i=0;i<k;i++){
            //base case,不足 k 个，不需要反转
            if(b==null){
                return head;
            }
            b = b.next;
        }
        ListNode a = head;
        //反转区间链表
        ListNode nexthead = reverseN(a,b);
        // 递归反转后续链表并连接起来
        a.next = reverseKGroup(b,k);
        return nexthead;

    }
    //反转区间a,b元素
    public ListNode reverseN(ListNode a,ListNode b){
        ListNode pre = null,cur = a,nxt = null;
        while(cur!=b){
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
}
