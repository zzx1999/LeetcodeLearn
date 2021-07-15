package dp;

public class maxSubArray {
    public int maxsubarray(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int dp0 = nums[0], dp1;
        int res = dp0;
        for (int i = 1; i < n; i++) {
            dp1 = Math.max(nums[i], dp0 + nums[i]);
            res = Math.max(res, dp1);
            dp0 = dp1;
        }
        return res;
    }
}
