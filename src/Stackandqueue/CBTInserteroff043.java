package Stackandqueue;

import backtrack_off.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class CBTInserteroff043 {
    TreeNode root;
    Queue<TreeNode> q;
    public CBTInserteroff043(TreeNode root) {
        this.root = root;
        q = new LinkedList<>();
        q.offer(root);
        while(q.peek().left!=null&&q.peek().right!=null){//保证队列第一个节点就是不完整节点
            q.offer(q.peek().left);
            q.offer(q.peek().right);
            q.poll();
        }
    }

    public int insert(int v) {
        // while (q.peek().left!=null&&q.peek().right!=null){
        //     q.poll();
        // }
        TreeNode front = q.peek();
        TreeNode node = new TreeNode(v);
        if(front.left==null){
            front.left = node;
        }
        else{
            front.right = node;//补上右边就完整了，把完整节点弹出去，左右节点加进来
            q.offer(front.left);
            q.offer(node);
            q.poll();
        }
        return front.val;
    }

    public TreeNode get_root() {
        return root;
    }
}
