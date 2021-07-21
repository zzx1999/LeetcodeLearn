package BFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class minDepth {
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int step = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0;i<size;i++){
                TreeNode cur = queue.poll();
                if(cur.left == null&&cur.right == null){
                    return step;
                }
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
            }
            step++;
        }
        return step;
    }
}
