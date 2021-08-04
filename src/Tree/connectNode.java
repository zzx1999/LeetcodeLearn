package Tree;

public class connectNode {
    public Node connect(Node root) {
        if(root==null)
            return null;
        connectNodes(root.left,root.right);
        return root;
    }
    public void connectNodes(Node node1,Node node2){
        if(node1==null||node2==null)
            return;
        node1.next = node2;
        // 连接相同父节点的两个子节点
        connectNodes(node1.left,node1.right);
        // 连接跨越父节点的两个子节点
        connectNodes(node1.right,node2.left);
        // 连接相同父节点的两个子节点
        connectNodes(node2.left,node2.right);
    }
}
