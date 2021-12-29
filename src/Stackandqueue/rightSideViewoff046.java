package Stackandqueue;

import backtrack_off.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class rightSideViewoff046 {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> res = new LinkedList<>();
        if(root!=null)
            q.offer(root);
        while (!q.isEmpty()){
            int size = q.size();
            res.add(q.peek().val);
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                if(node.right!=null) q.offer(node.right);
                if(node.left!=null) q.offer(node.left);
            }
        }

        return res;
    }
}
