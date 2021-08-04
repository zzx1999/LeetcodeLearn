package Tree;

public class FlattenTree {
    public void flatten(TreeNode root) {
        if(root==null)
            return;
        flatten(root.left);
        flatten(root.right);
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        //将整个左子树作为右子树
        root.right = left;
        TreeNode temp = root;
        //找到右子树的末端
        while (temp.right!=null){
            temp = temp.right;
        }
        //原来的右子树接到左子树下方
        temp.right = right;
        return;
    }
}
