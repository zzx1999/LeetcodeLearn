package dp;

import java.util.Arrays;

public class dicesProbabilityoff60 {
    public double[] dicesProbability(int n) {
        double[] dp = new double[6];//n个筛子 和为x的概率,dp(n,x)只和dp(n-1,x-1),dp(n-1,x-2),...,dp(n-1,x-6)有关
        Arrays.fill(dp,1.0/6);
        for(int i=2;i<=n;i++){
            double[] tmp = new double[5*i+1];
            for(int j=0;j<dp.length;j++){//计算dp[j]对下一个状态的贡献
                for(int k=0;k<6;k++){
                    tmp[j+k] += dp[j]/6.0;//dp就是f(n-1,x),tmp是f(n,y),产生改变的就是f(n,x+1),...,f(n,x+6)_
                }
            }
            dp = tmp;

        }
        return dp;
    }

    public static void main(String[] args) {
        int n = 2;
        dicesProbabilityoff60 dpb = new dicesProbabilityoff60();
        System.out.println(Arrays.stream(dpb.dicesProbability(n)).toArray());
    }
}
