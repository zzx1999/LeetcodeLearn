package QaDay;

import java.rmi.MarshalException;
import java.util.Arrays;

public class findCheapestPrice787 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        final int INF = 10000 * 101 + 1;
        //经过t次中转恰好达到i点的Mincost
        int[][] dp = new int[k+2][n];
        for(int i=0;i<=k+1;i++){
            Arrays.fill(dp[i],INF);
        }
        dp[0][src] = 0;
        //可以中转k次 最多搭乘k+1次航班
        for(int t = 1;t<=k+1;t++){
            for(int flight[]:flights){
                int j = flight[0],i = flight[1],cost = flight[2];
                dp[t][i] = Math.min(dp[t][i],dp[t-1][j]+cost);

            }
        }
        int res = INF;
        for(int t = 1;t<=k+1;t++){
            res = Math.min(res,dp[t][dst]);
        }
        return res==INF?-1:res;
    }
//    public int findCheapestPrice_mysol(int n, int[][] flights, int src, int dst, int k) {
//        int[][] dp = new int[k+2][n];
//
//    }
//    public int Mincost(int[][] fmatrix,int t,int k,int n){
//        int mincost = Integer.MAX_VALUE;
//        for(int i = 0;i<n;i++){
//            if(fmatrix[i][t]!=Integer.MAX_VALUE){
//                mincost = Math.min(mincost,dp[i][k] + fmatrix[i][t]);
//            }
//        }
//        return mincost;
//
//    }

    public static void main(String[] args) {
        int n = 3,k = 2;
        int[][] flights = {{0,1,100},{1,2,100},{0,2,500}};
        int src = 0,dst = 2;
        findCheapestPrice787 fcp = new findCheapestPrice787();
        System.out.println(fcp.findCheapestPrice(n,flights,src,dst,k));
    }
}
