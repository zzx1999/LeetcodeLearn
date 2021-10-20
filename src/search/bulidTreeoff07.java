package search;

import java.util.HashMap;
import java.util.Map;

public class bulidTreeoff07 {
    Map<Integer,Integer> inordermap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //前序遍历确定根节点,中序遍历确定根节点位置从而确定左右子树
        for(int i=0;i<inorder.length;i++){
            inordermap.put(inorder[i],i);
        }
        int n = preorder.length;
        //递归
        return Mytreebulid(preorder,inorder,0,n-1,0,n-1);
    }
    public TreeNode Mytreebulid(int[] preorder, int[] inorder,int preleft,int preright,int inleft,int inright) {
        if(preleft>preright)
            return null;
        TreeNode root = new TreeNode(preorder[preleft]);
        int rootindex = inordermap.get(preorder[preleft]);//根节点位置
        int leftlen = rootindex-inleft;
        int rightlen = inright-rootindex-1;
        root.left = Mytreebulid(preorder,inorder,preleft+1,preleft+leftlen,inleft,inleft+rightlen);
        root.right = Mytreebulid(preorder,inorder,preleft+leftlen+1,preright,rootindex+1,inright);
        return root;
    }
}
