package QaDay;
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
public class pathSum437 {
    public int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        return 0;
    }
    public void dfs(TreeNode node,int targetSum){
        if(node==null){
            return;
        }
        if(targetSum==0){
            count++;
            return;
        }
        targetSum -= node.val;
        dfs(node.left,targetSum);
        dfs(node.right,targetSum);
        return;
    }
}
