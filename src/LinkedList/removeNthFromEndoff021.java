package LinkedList;

public class removeNthFromEndoff021 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //删除倒数n个节点联想快慢指针
        //快指针先走n+1个位置再一起走
        ListNode fast = new ListNode(0);//创建辅助节点,避免[1],1的情况
        fast.next = head;
        head = fast;
        ListNode slow = fast;
        for (int i=0;i<=n;i++){
            fast = fast.next;
        }
        while (fast!=null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head.next;
    }
}
