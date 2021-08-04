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
        // ������ͬ���ڵ�������ӽڵ�
        connectNodes(node1.left,node1.right);
        // ���ӿ�Խ���ڵ�������ӽڵ�
        connectNodes(node1.right,node2.left);
        // ������ͬ���ڵ�������ӽڵ�
        connectNodes(node2.left,node2.right);
    }
}
