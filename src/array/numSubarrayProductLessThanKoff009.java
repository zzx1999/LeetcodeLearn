package array;

public class numSubarrayProductLessThanKoff009 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        //相当于求乘积小于k的最长连续子数组
        int l=0,res = 1;
        int count = 0;
        for(int r=0;r<nums.length;r++){
            res *= nums[r];
            while (res>=k){
                res /= nums[l];
                l++;
            }
            int len = r-l+1;
            count += len>0?len:0;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {10,5,2,6};
        int k = 100;
        numSubarrayProductLessThanKoff009 nspt = new numSubarrayProductLessThanKoff009();
        nspt.numSubarrayProductLessThanK(nums,k);
    }
}
