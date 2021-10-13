package search;

public class isBalancedoff55_2 {
    public boolean isBalanced(TreeNode root) {
        if (root==null)
            return true;
        int leftDepth = dfs(root.left);
        int rightDepth = dfs(root.right);
        return Math.abs(leftDepth-rightDepth)<=1&&isBalanced(root.left)&&isBalanced(root.right);
    }
    public int dfs(TreeNode root){
        if(root==null)
            return 0;
        int depth = Math.max(dfs(root.left)+1,dfs(root.right)+1);
        return depth;
    }
}
