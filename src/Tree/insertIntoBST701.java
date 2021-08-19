package Tree;

public class insertIntoBST701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        if(root.val>val) //val应该插入到root左边
            root.left = insertIntoBST(root.left,val);
        if(root.val<val)
            root.right = insertIntoBST(root.right,val);
        return root;
    }
}
