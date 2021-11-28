package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class detectCycleoff022 {
    public ListNode detectCycle(ListNode head) {
        Map<ListNode,Integer> listmap = new HashMap<>();
        ListNode index = head;
        int i = 0;
        while (index!=null){
            if(!listmap.containsKey(index)){
                listmap.put(index,i);
            }
            else{
                return index;
            }
            i++;
            index = index.next;

        }
        return null;

    }
    //快慢指针
    public ListNode detectCycl_opt(ListNode head) {
        //判断链表是否有环:快慢指针,如果有环快慢指针一定会相遇
        ListNode slow = head,fast = head;
        while (fast!=null && fast.next!=null){
            slow = slow.next;//slow走一步
            fast = fast.next.next;//fast走两步
            if(slow==fast){//如果相遇;就开始定位入口,此时慢指针走了x+y,快指针走了x + n(y+z) +y,快指针走的是慢指针走的两倍2(x+y) = (x+y) + n(y+z)
                //x+y = n(y+z),所以x = (n-1)y+z
                //此时设定一个指针ptr,和slow同步走,当ptr到入口(走了x时)慢指针走了(n-1)y+z+y = n(y+z)也正好到入口
                ListNode ptr = head;
                while (ptr!=slow){
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;

            }
        }
        return null;
    }
}
