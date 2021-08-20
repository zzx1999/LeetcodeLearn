package Tree;

public class deleteNode450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;
        if(root.val == key){
            //情况一，恰好是末端节点
            if(root.left==null&&root.right==null){
                return null;
            }
            //情况二， 只有一个非空子节点
            if(root.left==null) return root.right;
            if(root.right==null) return root.left;
            //情况三，有两个子节点，找到左子树中最大的那个节点，或者右子树中最小的那个节点来接替自己
            TreeNode min = getMin(root.right);
            root.val = min.val;// 把 root 改成 minNode
            root.right = deleteNode(root.right,min.val);//删右子树最小节点
        }
        if(root.val > key){
            root.left = deleteNode(root.left,key);
        }
        if(root.val < key){
            root.right = deleteNode(root.right,key);
        }
        return root;

    }
    public TreeNode getMin(TreeNode root){
        while(root.left!=null)
        {
            root = root.left;
        }
        return root;
    }
}
