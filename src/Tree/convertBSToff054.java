package Tree;

import java.time.temporal.Temporal;
import java.util.LinkedList;
import java.util.List;

public class convertBSToff054 {
    List<TreeNode> nodeval = new LinkedList<>();
    public TreeNode convertBST(TreeNode root) {
//        dfs(root);
//        List<Integer> preSum = new LinkedList<>();
//        int sum = 0;
//        //计算前缀和
//        for(int i=0;i<nodeval.size();i++){
//            sum += nodeval.get(i).val;
//            preSum.add(sum);
//        }
//        for(int i=0;i<preSum.size();i++){
//            nodeval.get(i).val = preSum.get(i);
//        }
        dfs_preSum(root);
        return root;

    }
    //反向中序遍历
    public void dfs(TreeNode root){
        if(root==null)
            return ;
        dfs(root.right);
        nodeval.add(root);
        dfs(root.left);
    }
    int preSum = 0;
    public void dfs_preSum(TreeNode root){
        if (root==null)
            return;
        dfs_preSum(root.right);
        root.val = (preSum += root.val);
        dfs_preSum(root.left);
    }
}
