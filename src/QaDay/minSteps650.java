package QaDay;

public class minSteps650 {
    public int minSteps(int n) {
        int[] dp = new int[n+1];
        dp[1] = 0;//1-0,2-2,3-3,4-4,5-4,6-5,7-5
        for(int i=2;i<=n;i++){
            dp[i] = Integer.MAX_VALUE;
            for(int j = 1;j<=Math.sqrt(i);j++){
                //使用一次「复制全部」操作，再使用若干次「粘贴」
                // 操作得到 i 个 A
                //这里的 j 必须是 i 的因数，
                // 「粘贴」操作的使用次数即为 i/j−1
                if(i%j==0){
                    dp[i] = Math.min(dp[i],dp[j]+i/j);
                    dp[i] = Math.min(dp[i],dp[i/j]+j);//???
                }


            }

        }
        return dp[n];
    }
}
