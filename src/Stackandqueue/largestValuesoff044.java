package Stackandqueue;

import backtrack_off.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class largestValuesoff044 {
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> res = new LinkedList<>();
        int nums = Integer.MIN_VALUE;
        if(root!=null)
            q.offer(root);
        while (!q.isEmpty()){
            int l = q.size();
            for(int i=0;i<l;i++){
                TreeNode tmp = q.poll();
                nums = Math.max(nums,tmp.val);
                if(tmp.left!=null) q.offer(tmp.left);
                if(tmp.right!=null) q.offer(tmp.right);
            }
            res.add(nums);
            nums = Integer.MIN_VALUE;
        }
        return res;
    }
}
