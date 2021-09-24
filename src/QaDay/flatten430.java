package QaDay;
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
public class flatten430 {
    public Node flatten(Node head) {
        //迭代方法
        Node cur = head;
        dfs(cur);
        return head;

    }
    //优化，定义一个函数额外返回一个尾节点
    public Node dfs(Node node){
        Node cur = node;
        //记录最后一个节点
        Node last = cur;
        while(cur!=null){
            Node next = cur.next;
            //有子节点处理子节点
            if(cur.child!=null){
                Node childList = dfs(cur.child);
                next = cur.next;
                //node和子节点相连
                cur.next = cur.child;
                cur.child.prev = cur;
                if(next!=null){//如果分支后面不是空则将分支后面的节点接到子链表后面
                    childList.next = next;
                    next.prev = childList;
                }
                cur.child = null;//child置空
                last = childList;
            }
            else{
                last = cur;
            }
            cur = cur.next;
        }
        return last;
    }
    //递归方法_原始
    public Node RecurionWays(Node node){
        Node dummy = node;
        while(node!=null){
            if(node.child==null)
                node = node.next;
            else{
                Node flattennode = RecurionWays(node.child);
                //node和node.child相连
                Node tmp = node.next;
                node.next = flattennode;
                flattennode.prev = node;
                node.child = null;
                //子链表尾部要和node.next相连
                while(node.next!=null) node = node.next;
                node.next = tmp;
                if(tmp!=null) tmp.prev = node;
                node = tmp;
            }
        }

        return dummy;
    }
}
