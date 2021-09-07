package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class copyRandomListoff35 {
    Map<Node,Node> listmap = new HashMap<>();//记录新节点和原始节点
    public Node copyRandomList(Node head) {
        if(head == null)
            return null;
        if (!listmap.containsKey(head)){
            Node headnew = new Node(head.val);
            listmap.put(head,headnew);
            headnew.next = copyRandomList(head.next);//递归创建next和random节点
            headnew.random = copyRandomList(head.random);
        }
        return listmap.get(head);
    }
}
