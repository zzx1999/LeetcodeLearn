package search;
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
public class treeToDoublyListoff36 {
    Node pre,head;
    public Node treeToDoublyList(Node root) {
        if(root==null)
            return null;
        dfs(root);
        head.left = pre;//pre最后指向尾节点
        pre.right = head;
        return head;

    }
    public void dfs(Node root){
        if(root==null)
            return ;
        dfs(root.left);
        if(pre !=null) pre.right = root;
        else head = root;//如果pre是null，说明是头结点
        root.left = pre;
        pre = root;
        dfs(root.right);
    }
}
