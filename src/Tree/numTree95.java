package Tree;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.List;

public class numTree95 {
    public List<TreeNode> generateTrees(int n) {
        if(n==0) return new LinkedList<TreeNode>();
        return genrate(1,n);

    }
    public List<TreeNode> genrate(int lo,int hi){
        List<TreeNode> res = new LinkedList<>();
        if(lo>hi){
            res.add(null);
            return res;
        }
        //构造闭区间 [lo, hi] 组成的 BST
        for(int i=lo;i<=hi;i++){
            //递归构造出左右子树的所有合法BST
            List<TreeNode> left = genrate(lo,i-1);
            List<TreeNode> right = genrate(i+1,hi);
            //给 root 节点穷举所有左右子树的组合。
            for(TreeNode l:left){
                for(TreeNode r:right){
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }

        }
        return res;
    }
}
