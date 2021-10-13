package search;

import java.util.LinkedList;
import java.util.Queue;

//class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode(int x) { val = x; }
// }
public class maxDepthoff55_1 {
    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        int leftmaxrout = maxDepth(root.left)+1;
        int rightmaxrout = maxDepth(root.right)+1;
        return leftmaxrout>rightmaxrout?leftmaxrout:rightmaxrout;

    }
    public int BFS(TreeNode root){
        if(root==null)
            return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int count = 0;
        while(!q.isEmpty()){
            count++;
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode cur = q.poll();
                if(cur.left!=null) q.offer(cur.left);
                if(cur.right!=null) q.offer(cur.right);
            }
        }
        return count;
    }
}
