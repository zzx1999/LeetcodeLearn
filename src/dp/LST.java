package dp;

public class LST {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for(int i=0;i<n;i++){
            dp[i] = 1;
            for(int j = 0;j<i;j++){
                if(nums[j]<nums[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int res = 0;
        for(int i=0;i<n;i++){
            res = Math.max(res,dp[i]);
        }
        return res;

    }


}
