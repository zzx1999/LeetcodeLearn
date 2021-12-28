package Stackandqueue;

import backtrack_off.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class findBottomLeftValueoff045 {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int res = root.val;
        q.offer(root);
        while (!q.isEmpty()){
            int size = q.size();
            res = q.peek().val;
            for(int i=0;i<size;i++){
                TreeNode tmp = q.poll();
                if(tmp.left!=null) {
                    q.offer(tmp.left);
                }
                if(tmp.right!=null){
                    q.offer(tmp.right);
                }
            }
        }
        return res;
    }
}
