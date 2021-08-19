package Tree;

public class isValidBST98 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,null,null);

    }
    public boolean isValidBST(TreeNode root,TreeNode max,TreeNode min){
        if(root==null) return true;
        //违反规则判负
        if(max!=null&&root.val>=max.val){
            return false;
        }
        if(min!=null&&root.val<=min.val){
            return false;
        }
        //左子树最大值是root.val ，所以所有的左子节点要<max.val
        //右子树最小值是root.val,所以所有的右子节点要>min.val
        return isValidBST(root.left,root,min)&&isValidBST(root.right,max,root);

    }
}
