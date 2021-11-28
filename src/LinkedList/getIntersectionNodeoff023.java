package LinkedList;

public class getIntersectionNodeoff023 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
         //哈希表思路存A的节点再看看B链表里的节点有没有在哈希表里,时间:O(m+n),空间O(m)
        //这里用双指针,pa,pb同时移动,如果其中一个到了尽头就移到另外一个链表
        //如果A和B相交 两指针一定会相遇
        //证明,假设A和B不相交的节点分别有a个和b,相交的节点有c个如果相交,a = b那么两个指针会同时到达相交节点
        //如果a≠b,pa移动了a+c+b,pb移动了b+c+a次之后两指针会同时到达相交节点
        if(headA==null||headB==null)
            return null;
        ListNode pa = headA,pb = headB;
        while (pa!=pb){
            pa = pa == null?headB:pa.next;
            pb = pb == null?headA:pb.next;

        }
        return pa;
    }
}
