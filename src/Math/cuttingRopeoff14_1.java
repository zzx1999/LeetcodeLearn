package Math;

public class cuttingRopeoff14_1 {
    public int cuttingRope(int n) {
        //设dp[i]是长度为i的绳子被分成m份最大乘积值
        //dp[i]有三种情况,遍历j = 1,..,i;可能分两份j*(i-j),可能分成m份即从dp[i-j]转移来的就是分成了三份及以上 j * dp[i-j]
        int[] dp = new int[n+1];
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            for (int j=1;j<=n;j++){
                dp[i] = Math.max(Math.max(j * (i-j),j * dp[i-j]),dp[i]);
            }
        }
        return dp[n];
    }
}
