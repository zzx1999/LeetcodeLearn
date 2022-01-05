package Stackandqueue;

import backtrack_off.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class sumNumbersoff049 {
//    int sum = 0;
    public int sumNumbers(TreeNode root){
        //dfs
        return dfs(root,0);

    }
    public int dfs(TreeNode root,int presum){
        if(root==null){
            return 0;
        }
        int sum = presum*10+root.val;
        if(root.left==null&&root.right==null){//到达叶子节点
            return sum;
        }
        else{
            return dfs(root.left,sum)+dfs(root.right,sum);
        }


    }
}
