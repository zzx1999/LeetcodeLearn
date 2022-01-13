package Tree;

import com.sun.source.tree.Tree;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class findTargetoff056 {
    //dfs+栈
//    Stack<Integer> treest = new Stack<>();
//    boolean res = false;
//    public boolean findTarget(TreeNode root, int k) {
//        dfs(root,k);
//        return res;
//    }
//    public void dfs(TreeNode root,int t){//是否存在节点值为t的
//        if(root==null)
//            return;
//        dfs(root.left,t);
//        if(!treest.isEmpty()&&treest.contains(t- root.val)) res = true;
//        treest.push(root.val);
//        dfs(root.right,t);
//    }
    //dfs+哈希表
    Set<Integer> treeset = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        if(root==null)
            return false;
        if(treeset.contains(k-root.val)) return true;
        treeset.add(root.val);
        return findTarget(root.left,k)||findTarget(root.right,k);


    }
}
