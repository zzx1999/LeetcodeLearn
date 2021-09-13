package backtrack;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class levelOrderoff32_3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root==null)
            return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int loops = 0;
        while (!q.isEmpty()){
            int size = q.size();
            List<Integer> l = new LinkedList<>();
            for(int i=0;i<size;i++){
                TreeNode cur = q.poll();
                l.add(cur.val);
                if(cur.left!=null) q.offer(cur.left);
                if(cur.right!=null) q.offer(cur.right);
            }
            if(loops%2==0){
                res.add(l);
            }
            else{
                Collections.reverse(l);
                res.add(l);
            }
            loops++;
        }
        return res;
    }
}
