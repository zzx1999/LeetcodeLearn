package Tree;

public class increasingBSToff052 {
    TreeNode pre;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummy = new TreeNode(-1);
        pre = dummy;
        dfs(root);
        return pre.right;
//        return newnode.right;
    }
    public void dfs(TreeNode root){
        if(root==null)
            return ;
        dfs(root.left);//先向左遍历
        root.left = null;
        pre.right = root;//前一个指针指向最左边的一个节点
        pre = root;//更新前一个指针
//        newnode.right = root;
//        root.left = null;
//        newnode = root;
        dfs(root.right);
    }
}
