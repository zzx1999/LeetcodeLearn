package Tree;

import java.util.LinkedList;
import java.util.List;

public class BSTIteratoroff055  {
    List<TreeNode> treelist = new LinkedList<>();
    int index = 0;
    public BSTIteratoroff055(TreeNode root) {
        treelist.add(new TreeNode(-1));
        dfs(root);
    }
    public void dfs(TreeNode root){
        if(root==null)
            return;
        dfs(root.left);
        treelist.add(root);
        dfs(root.right);
    }

    public int next() {
        index++;
        if(index<treelist.size())
            return treelist.get(index).val;
        else
            return -1;
    }

    public boolean hasNext() {
        if(index<treelist.size())
            return true;
        else
            return false;
    }
}
