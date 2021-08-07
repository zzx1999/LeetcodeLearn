package Tree;

import java.util.Arrays;

public class ConstructMaxTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int n = nums.length;
        if(n==0)
            return null;
        //�����������ֵ
        int maxVal = nums[0],index = 0;
        for(int i=0;i<n;i++){
            if(nums[i]>=maxVal){
                maxVal = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(maxVal);
        //�ݹ������������
        if(index>0) {
            int[] left = Arrays.copyOfRange(nums, 0, index);
            root.left = constructMaximumBinaryTree(left);
        }
        else
            root.left = null;
        if(index<n-1){
            int[] right = Arrays.copyOfRange(nums,index+1,n);
            root.right = constructMaximumBinaryTree(right);
        }
        else
            root.right = null;
        return root;


    }
}
