package search;

import java.util.LinkedList;
import java.util.List;

public class lowestCommonAncestoroff68_2 {
    TreeNode res = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)
            return res;
        if(dfscheck(root.left,p)&&dfscheck(root.left,q)){ //如果p,q都在左子树就往左子树上搜
            res = lowestCommonAncestor(root.left,p,q);

        }
        else if(dfscheck(root.right,p)&&dfscheck(root.right,q)){//如果p,q都在右子树就往右子树上搜
            res = lowestCommonAncestor(root.right,p,q);
        }
        else{
            res = root;
        }
        return res;
    }
    public boolean dfscheck(TreeNode root,TreeNode node){
        if(root==null)
            return false;
        if(root.val== node.val) return true;
        return (dfscheck(root.left,node)||dfscheck(root.right,node));
    }
    public TreeNode lowestCommonAncestor_Timeout(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)
            return res;
        if(root.val==p.val||root.val==q.val){
            res = root;
            return res;
        }
        List<Integer> left = new LinkedList<>();
        List<Integer> right = new LinkedList<>();
        searchdfs(root.left,left);
        searchdfs(root.right,right);
        if(left.contains(p.val)&&left.contains(q.val)){
            res = lowestCommonAncestor(root.left,p,q);
        }
        else if(right.contains(p.val)&&right.contains(q.val)){
            res = lowestCommonAncestor(root.right,p,q);
        }
        else{
            res = root;
        }
        return res;




    }
    public void searchdfs(TreeNode root,List<Integer> list){
        if(root==null)
            return;
       list.add(root.val);
       if(root.left!=null) searchdfs(root.left,list);
       if(root.right!=null) searchdfs(root.right,list);
    }
}
