package Tree;

public class Treeinvert {
    public TreeNode invertTree(TreeNode root) {
        if(root==null)
            return null;
        TreeNode tempnode = root.left;
        root.left = root.right;
        root.right = tempnode;
        invertTree(root.left);
        invertTree(root.right);
        return root;

    }
}
