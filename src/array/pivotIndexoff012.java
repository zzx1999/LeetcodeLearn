package array;

import java.util.Arrays;

public class pivotIndexoff012 {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] prexSum = new int[n];
        int sum = Arrays.stream(nums).sum();
        int prexsum = 0;
        if(sum==0) return 0;
        for(int i=0;i<n;i++){
            prexsum += nums[i];
            int tmp = (sum-nums[i])/2;
            if(prexsum-nums[i]==tmp)
                return nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,7,3,6,5,6};
        pivotIndexoff012 pi = new pivotIndexoff012();
        pi.pivotIndex(nums);
    }
}
