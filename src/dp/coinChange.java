package dp;

import java.util.Arrays;

public class coinChange {
    //暴力递归
    //时间复杂度是指数级别（可以化递归树，时间复杂度就是递归树节点个数×每一次递归的时间复杂度）
    //在力扣里面超时,因为子问题重复计算了
    public int coinChange(int[] coins, int amount) {
        if(amount==0) return 0;
        if(amount<0) return -1;
        int res = Integer.MAX_VALUE;
        for(int coin:coins){
            int sub = coinChange(coins,amount-coin);
            if(sub == -1) continue;
            res = Math.min(res,sub+1);

        }
        if(res!=Integer.MAX_VALUE)
            return res;
        else
            return -1;
    }
    //带备忘录递归
    public int coinChange2(int[] coins, int amount) {
        if(amount<1) return 0;
        return coinChange2(coins,amount,new int[amount+1]);

    }
    public int coinChange2(int[] coins, int amount,int[] memory) {
        //base case
        if(amount==0) return 0;
        if(amount<0) return -1;
        //查看备忘录避免重复计算
        if(memory[amount]!=0) return memory[amount];
        int res = Integer.MAX_VALUE;
        for(int coin:coins){
            int sub = coinChange2(coins,amount-coin,memory);
            if(sub == -1) continue;
            res = Math.min(res,sub+1);

        }
        if(res!=Integer.MAX_VALUE) {
            memory[amount] = res;
        }
        else{
            memory[amount] = -1;

        }
        return memory[amount];

    }
    //dp数组迭代
    public int coinChange3(int[] coins, int amount) {
        //base case
        if(amount==0) return 0;
        if(amount<0) return -1;
        int[] dp = new int[amount+1];
        int max = amount+1;//使用硬币的数量是不会超过amount+1的，实现最差也是用amount个1元硬币凑
        Arrays.fill(dp,max);//先全部置为最大
        dp[0] = 0;
        for(int i=1;i<=amount;i++){
            for(int coin:coins){
                if(i - coin<0) continue;
                dp[i] = Math.min(dp[i],1+dp[i-coin]);

            }
        }
        return dp[amount] > amount ? -1:dp[amount];

    }

    public static void main(String[] args) {
        int[] coins = {2};
        int amount = 3;
        coinChange cc = new coinChange();
        System.out.println(cc.coinChange2(coins,amount));
    }

}
