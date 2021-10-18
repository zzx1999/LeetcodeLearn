package QaDay;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class kthSmallest230 {
    List<Integer> res = new LinkedList<>();
    PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->b-a);//大根堆
    int index = 0;
    public int kthSmallest(TreeNode root, int k) {
//        gettreeval(root,k);
//        return res.get(k);
        return BFS_Priority(root,k);

    }
    //中序遍历
    public void gettreeval(TreeNode root,int k){
        if(root==null)
            return;
        if(root.left!=null) gettreeval(root.left,k);
        res.add(root.val);
        if(root.right!=null) gettreeval(root.right,k);

    }
    //树的遍历+优先队列
    public int BFS_Priority(TreeNode root,int k){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        queue.add(root.val);
        while (!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i<size;i++){
                TreeNode cur = q.poll();
                if(cur.val<queue.peek()){
                    if(queue.size()==k){
                        queue.poll();
                        queue.add(cur.val);

                    }
                    else if(queue.size()<k){
                        queue.add(cur.val);
                    }
                }
            }
        }
        return queue.peek();
    }
}
