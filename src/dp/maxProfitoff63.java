package dp;

import java.util.Arrays;

public class maxProfitoff63 {
    //只要用一个变量记录一个历史最低价格 minprice，我们就可以假设自己的股票是在那天买的。
    // 那么我们在第 i 天卖出股票能得到的利润就是 prices[i] - minprice
    //
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n==0)
            return 0;
        int[] dp = new int[n];//前i天的最大利润
        dp[0] = 0;
        int cost = prices[0];//成本
        for(int i=1;i<n;i++){
            dp[i] = Math.max(dp[i-1],prices[i]-cost);//比较第i天卖出和不是第i天卖出；
            cost = Math.min(cost,prices[i]);//取最小成本
        }
        return dp[n-1];

    }

    public static void main(String[] args) {
        int[] p = {7,1,5,3,6,4};
        maxProfitoff63 mp = new maxProfitoff63();
        System.out.println(mp.maxProfit(p));
    }
}