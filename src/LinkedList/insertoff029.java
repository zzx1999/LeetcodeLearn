package LinkedList;

public class insertoff029 {
    public Node insert(Node head, int insertVal) {
        if(head==null){
            Node res = new Node(insertVal);
            res.next = res;
            return res;
        }
        if(head.next==head){
            Node insert = new Node(insertVal);
            head.next = insert;
            insert.next=head;
            return head;
        }
        Node cur = head;
//        Node minnode = cur,maxnode = cur;//记录最小值最大值节点
        Node insert = new Node(insertVal);
        while (cur.next!=head){
            if(cur.val<insertVal&&cur.next.val>insertVal){
                Node tmp = cur.next;
                cur.next = insert;
                insert.next = tmp;
                return head;
            }
            if (cur.val>cur.next.val){//临界点
                if(cur.val<=insertVal&&cur.next.val<=insertVal)//最大值
                    break;
                else if(cur.val>=insertVal&&cur.next.val>=insertVal)//最小值
                    break;

            }
            else {
//                minnode = cur.val<minnode.val?cur:minnode;
//                maxnode = cur.val>maxnode.val?cur:maxnode;
                cur = cur.next;
            }
        }
        cur.next = new Node(insertVal,cur.next);
        //如果转了一圈还没有找到插入位置,要么就是最大值要么就是最小值
//        if(minnode.val>insertVal){
//            Node insert = new Node(insertVal);
//            maxnode.next = insert;
//            insert.next = minnode;
//        }
        return head;
    }
}
