package LinkedList;

import java.util.Stack;

public class addTwoNumbersoff025 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        ListNode cur = null;
        while (l1!=null||l2!=null){
            if(l1!=null){
                s1.push(l1.val);
                l1 = l1.next;
            }
            if(l2!=null){
                s2.push(l2.val);
                l2 = l2.next;
            }
        }
        int isPro = 0,curval = 0;
        while (!s1.isEmpty()||!s2.isEmpty()){
            curval = 0;
            if(s1.isEmpty()&&!s2.isEmpty()){
                curval+=s2.pop();
            }
            else if(s2.isEmpty()&&!s1.isEmpty())
                curval += s1.pop();
            else{
                curval = s1.pop()+s2.pop();
            }
            curval += isPro;//加上进位值
            if(curval>9){
                isPro = 1;
                curval -= 10;
            }
            else
                isPro = 0;
            ListNode node = new ListNode(curval);
            node.next = cur;
            cur = node;
        }
        if(isPro>0){//存在最后一次进位可能
            ListNode node = new ListNode(isPro);
            node.next = cur;
            cur = node;
        }
        return cur;
    }
}
