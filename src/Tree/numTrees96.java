package Tree;

public class numTrees96 {
    int[][] memo;
    public int numTrees(int n) {
        memo = new int[n+1][n+1];
        return count(1,n);

    }
    /* 计算闭区间 [lo, hi] 组成的 BST 个数 */
    public int count(int lo,int hi){
        if(lo>hi) return 1;
        if(memo[lo][hi]!=0)
            return memo[lo][hi];
        int res = 0;
        for(int i = lo;i<=hi;i++){
            // i 的值作为根节点 root
            int left = count(lo,i-1);
            int right = count(i+1,hi);
            res += left * right;
        }
        memo[lo][hi] = res;
        return res;
    }
}
