package search;

public class lowestCommonAncestoroff68_1 {
    TreeNode res = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)
            return res;
        if(root!=null&&((p.val>root.val&&q.val<root.val)||(p.val<root.val&&q.val>root.val))){
            res = root;
        }
        else if(p.val<root.val&&q.val < root.val){
            res = lowestCommonAncestor(root.left,p,q);
        }
        else if(p.val>root.val&&q.val>root.val){
            res = lowestCommonAncestor(root.right,p,q);
        }
        else if(p.val==root.val){
            res = p;
        }
        else if(q.val== root.val){
            res = q;
        }
        return res;
    }
}
