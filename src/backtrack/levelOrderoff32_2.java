package backtrack;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class levelOrderoff32_2 {
    //BFS
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root == null)
            return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            int size = q.size();
            List<Integer> layer = new LinkedList<>();
            for(int i=0;i<size;i++){
                TreeNode cur = q.poll();
                layer.add(cur.val);
                if(cur.left!=null) q.offer(cur.left);
                if(cur.right!=null) q.offer(cur.right);
            }
            res.add(layer);
        }
        return res;
    }
    public List<List<Integer>> levelOrder_wrong(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root==null)
            return res;
        List<Integer> rootlayer = new LinkedList<>();
        rootlayer.add(root.val);
        res.add(rootlayer);
        layersearch(root,res);
        return res;

    }
    //不行！要输出的是一层里面所有节点的值不能只是左右子树
    public void layersearch(TreeNode root,List<List<Integer>> res){
        if(root==null)
            return;
        List<Integer> layerval = new LinkedList<>();
        if(root.left!=null) layerval.add(root.left.val);
        if(root.right!=null) layerval.add(root.right.val);
        if(layerval.size()!=0)
            res.add(layerval);
        layersearch(root.left,res);
        layersearch(root.right,res);
    }
}
