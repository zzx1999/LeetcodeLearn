package search;

import java.util.LinkedList;
import java.util.List;

public class kthLargestoff54 {
    List<Integer> treelist = new LinkedList<>();
    public int kthLargest(TreeNode root, int k) {
        if (root==null)
            return 0;
        dfs(root);
        return treelist.get(k-1);
    }
    //中序遍历即升序遍历
    public void dfs(TreeNode root){
        if(root==null)
            return;
        dfs(root.right);
        treelist.add(root.val);
        dfs(root.left);
    }
}
