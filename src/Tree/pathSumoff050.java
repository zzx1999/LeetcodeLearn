package Tree;

import backtrack_off.TreeNode;

public class pathSumoff050 {
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null)
            return 0;
        int sum = rootSum(root,targetSum)+pathSum(root.left,targetSum)+pathSum(root.right,targetSum);
        return sum;

//        else{
//            return pathSum(root.left,targetSum-root.val) + pathSum(root.left,targetSum)+pathSum(root.right,targetSum-root.val)+pathSum(root.right,targetSum);
//        }
    }

    public int rootSum(TreeNode root,int val){//包含该节点的路径和为val的路径数目
        if(root==null)
            return 0;
        int sum = 0;
        if(root.val == val){
            sum++;
        }
        sum += rootSum(root.left,val-root.val);
        sum += rootSum(root.right,val-root.val);
        return sum;

    }
}
