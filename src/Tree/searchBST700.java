package Tree;

public class searchBST700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;
        if(root.val == val) return root;
        //说明val在右子树
        if(root.val<val){
            return searchBST(root.right,val);
        }
        //说明val在左子树
        if(root.val > val){
            return searchBST(root.left,val);
        }
        return null;

    }
}
