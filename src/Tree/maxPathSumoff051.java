package Tree;

import backtrack_off.TreeNode;

public class maxPathSumoff051 {
    int maxres = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxRootSum(root);
        return maxres;
    }
    public int maxRootSum(TreeNode root){//包含该节点的最大路径和
        if(root==null)
            return 0;
        int lmax = Math.max(0,maxRootSum(root.left));
        int rmax = Math.max(0,maxRootSum(root.right));
        maxres = Math.max(root.val+lmax+rmax,maxres);
        return root.val + Math.max(lmax,rmax);


    }
}
