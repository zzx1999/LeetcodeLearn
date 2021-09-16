package dp;

public class maxSubArrayoff42 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];//包含i的最大连续子数组和
        int maxsum = nums[0];
        for(int i=1;i<n;i++){
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            maxsum = Math.max(maxsum,dp[i]);
//            dp[i] = Math.max(Math.max(nums[i],dp[i-1]+nums[i]),dp[i-1]);
        }
        return maxsum;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        maxSubArrayoff42 ms = new maxSubArrayoff42();
        System.out.println(ms.maxSubArray(nums));
    }


}
