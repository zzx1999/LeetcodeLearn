package search;

import java.util.*;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
public class pathSumoff34 {
    List<List<Integer>> res = new LinkedList<>();
    Deque<Integer> route = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root,target);
        return res;

    }
    //dfs+回溯
    public void dfs(TreeNode node,int target){
        if(node==null)
            return;
        route.offerLast(node.val);//先把该节点加到路径
        target -= node.val;
        //如果到达叶子节点且满足target就返回
        if(node.left==null&&node.right==null&&target==0){
            res.add(new LinkedList<>(route));
        }
        dfs(node.left,target);
        dfs(node.right,target);
        route.pollLast();//回溯
    }
//    //bfs
//    public List<List<Integer>> bfs(TreeNode node,int target){
//        Queue<TreeNode> qpath = new LinkedList<>();
//        Queue<Integer> qSum = new LinkedList<>();
//        qpath.offer(node);
//        qSum.offer(0);
//        while (!qpath.isEmpty()){
//            TreeNode tmp = qpath.poll();
//            int sum = qSum.poll() + tmp.val;
//            //到达叶子节点
//            if(tmp.left==null&&tmp.right==null&&target==sum){
//                res.add()
//            }
//        }
//
//
//    }
}
