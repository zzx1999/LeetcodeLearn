package backtrack;

public class isSymmetricoff27 {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        return recur(root.left,root.right);


    }
    public boolean recur(TreeNode L,TreeNode R){
        if(L==null&&R==null)
            return true;
        if(L==null)
            return false;
        if(R==null)
            return false;
        if(L.val!=R.val)
            return false;
        return recur(L.left,R.right)&&recur(L.right,R.left);

    }
}
