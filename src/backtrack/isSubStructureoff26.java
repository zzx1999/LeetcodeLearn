package backtrack;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class isSubStructureoff26 {
    //dfs
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A==null||B==null)
            return false;
        return recur(A,B)||isSubStructure(A.left,B)||isSubStructure(A.right,B);


    }
    public boolean recur(TreeNode A,TreeNode B){
        if(B==null)
            return true;
        if(A==null)
            return false;
        if(A.val!=B.val)
            return false;
        return recur(A.left,B.left)&&recur(A.right,B.right);
    }
    //用bfs不行，不能确定子节点属于哪个父节点
    public boolean isSubStructure_bfswrong(TreeNode A, TreeNode B) {
        List<Integer> lista = BFS(A);
        List<Integer> listb = BFS(B);
        if(listb.size()==0){
            return false;
        }
        int index = 0;
        for(Integer t:lista){
            if((t!=null&&t==listb.get(index))||(t==null&&listb.get(index)==null)){
                index++;
                if(index==listb.size()){
                    return true;
                }
            }
            else{
                index = 0;
            }
        }
        return index==listb.size();


    }
    public List<Integer> BFS(TreeNode root) {
        Queue<TreeNode> q1 = new LinkedList<>();
        List<Integer> treea = new LinkedList<>();
        if (root == null)
            return treea;
        q1.offer(root);
        while (!q1.isEmpty()) {
            TreeNode cur = q1.poll();
            if(cur!=null)
                treea.add(cur.val);
            else{
                treea.add(null);
                continue;
            }

            if(cur.left!=null) q1.offer(cur.left);
            else q1.offer(null);
            if(cur.right!=null) q1.offer(cur.right);
            else q1.offer(null);
        }
        return treea;
    }
}
