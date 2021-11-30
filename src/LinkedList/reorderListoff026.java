package LinkedList;

public class reorderListoff026 {
    public void reorderList(ListNode head) {
        if(head==null)
            return;
        //就是把右半边链表翻转后和左半边链表合并起来
        //快慢指针找中点
        ListNode slow = head,fast = head;
        while (fast.next!=null&&fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //右边翻转,迭代
        ListNode cur = slow,pre = null;
        while (cur!=null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        //合并
        ListNode l1 = head,l2 = pre;
        while (l1!=null&&l2!=null){
            ListNode tmp1 = l1.next;
            ListNode tmp2 = l2.next;
            l1.next = l2;
            l2.next = tmp1;
            l1 = tmp1;
            l2 = tmp2;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for(int i=2;i<=4;i++){
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        reorderListoff026 rl = new reorderListoff026();
        rl.reorderList(head);
    }
}
