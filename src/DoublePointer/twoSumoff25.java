package DoublePointer;

public class twoSumoff25 {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int begin = 0,end = n-1;
        while (begin<end){
            if(nums[begin]+nums[end]>target){
                end--;
            }
            else if(nums[begin]+nums[end]<target){
                begin++;
            }
            else{
                int[] res = {nums[begin],nums[end]};
                return res;
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        twoSumoff25 ts = new twoSumoff25();
        ts.twoSum(nums,target);
    }
}
