package LinkedList;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class reversePrintoff06 {
    //超时
    public int[] reversePrint_Timeout(ListNode head) {
        List<Integer> res = new LinkedList<>();
        if(head==null)
            return new int[]{};
        if(head.next==null){
            return new int[]{head.val};
        }
        int[] arr = reversePrint_Timeout(head.next);
        for(int i:arr){
            res.add(i);
        }
        res.add(head.val);
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
    //辅助栈
    public int[] reversePrint(ListNode head) {
        Stack<Integer> st = new Stack<>();
        int n = 0;
        while (head!=null){
            st.push(head.val);
            n++;
            head = head.next;
        }
        int[] res = new int[n];
        int i=0;
        while(!st.isEmpty()){
            res[i] = st.pop();
            i++;
        }
        return res;

    }

}
