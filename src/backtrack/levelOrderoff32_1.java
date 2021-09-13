package backtrack;

import LinkedList.ListNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class levelOrderoff32_1 {
    //错，这是DFS
    List<Integer> res = new LinkedList<>();
    public int[] levelOrder_BFS(TreeNode root) {
        if(root == null)
            return new int[0];
        if(root.left==null&&root.right==null){
            res.add(root.val);
            return res.stream().mapToInt(Integer::intValue).toArray();
        }
        res.add(root.val);
        levelOrder(root.left);
        levelOrder(root.right);
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
    //回溯,是一种BFS
    //初始化： 打印结果列表 res = [] ，包含根节点的队列 queue = [root] ；
    //BFS 循环： 当队列 queue 为空时跳出；
    //
    //    出队： 队首元素出队，记为 node；
    //    打印： 将 node.val 添加至列表 tmp 尾部；
    //    添加子节点： 若 node 的左（右）子节点不为空，则将左（右）子节点加入队列 queue ；
    public int[] levelOrder(TreeNode root) {
        if(root == null)
            return new int[0];
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> res = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i<size;i++){
                TreeNode cur = q.poll();
                res.add(cur.val);
                if(cur.left!=null) q.offer(cur.left);
                if(cur.right!=null) q.offer(cur.right);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
    public void backtrack(TreeNode root,List<TreeNode> res){
        if(root==null){
            return;
        }
        res.add(root);
        backtrack(root.left,res);



    }

}
