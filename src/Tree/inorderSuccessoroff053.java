package Tree;

import backtrack_off.TreeNode;

public class inorderSuccessoroff053 {
    TreeNode pre = null,res = null;
    public TreeNode inorderSuccessor(TreeNode root,TreeNode p){
        dfs(root,p);
        return res;
    }
    public void dfs(TreeNode root,TreeNode p){
        if(root==null)
            return ;
        dfs(root.left,p);
        if(pre==p) res = root;
        pre = root;
        dfs(root.right,p);

    }
}
