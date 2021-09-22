package QaDay;

public class splitListToParts725 {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode cur = head;
        int len = 0;
        while(cur!=null){
            len++;
            cur = cur.next;
        }
        int group = len/k;
        int add = len % k;
        ListNode[] arr = new ListNode[k];
        int index = 0;
        while(head!=null){
            ListNode cur2 = head;
            ListNode listsplit = cur2;
            arr[index] = cur2;
            int partsize = group + (add>0?1:0);
            add--;
            for(int i=1;i<partsize;i++){
                if(listsplit==null){
                    break;
                }
                listsplit = listsplit.next;
            }
            head = listsplit.next;
            listsplit.next = null;
            index++;

        }
        if(index<k){
            for(int i=index;i<k;i++){
                arr[i] = null;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        splitListToParts725 sltp = new splitListToParts725();
        sltp.splitListToParts(head,5);
    }
}
