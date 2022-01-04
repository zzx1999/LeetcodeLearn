package Stackandqueue;

import backtrack_off.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Codecoff048 {
    // Encodes a tree to a single string.
    List<String> res = new LinkedList<>();
    public String serialize(TreeNode root) {
        if(root==null)
            return "null";
        res.add(String.valueOf(root.val));
        serialize(root.left);
        serialize(root.right);
        return String.join(",",res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String>  q = new LinkedList<>(Arrays.asList(data.split(",")));
        return dfs(q);

    }
    public TreeNode dfs(Queue<String> queue){
        if(queue.size()==0)
            return null;
        String val = queue.poll();
        if(val.equals("null")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = dfs(queue);
        root.right = dfs(queue);
        return root;
    }

    public static void main(String[] args) {
        String s = "1,2,3,null,null,4,5";
        Codecoff048 cc = new Codecoff048();
        cc.deserialize(s);

    }
}
