package backtrack;

public class movingCountoff13 {
    public int movingCount(int m, int n, int k) {
        int[][] board = new int[m][n];
        return dfs(board,0,0,m,n,k);
//        return res;
    }
    public int dfs(int[][] board,int i,int j,int m,int n,int k){
        if(i>=m||i<0||j>=n||j<0||checkijk(i,j,k)||board[i][j]==1) return 0;//这个格子不能踩
//        res++;//踩到了这个格子
        board[i][j]=1;
//        res += dfs(board,i+1,j,m,n,k)+dfs(board,i,j+1,m,n,k);//周围可以踩的格子
//        board[i][j] = 0;
        return 1 + dfs(board,i+1,j,m,n,k)+dfs(board,i,j+1,m,n,k);//1+向右可达总数+向下可达总数


    }

    private boolean checkijk(int i, int j, int k) {
        int sum = 0;
        while (i>0){
            sum += (i % 10);
            i /= 10;
        }
        while (j>0){
            sum += (j % 10);
            j /= 10;
        }
        return sum>k;
    }

    public static void main(String[] args) {
        int m = 3,n = 2,k = 17;
        movingCountoff13 mc = new movingCountoff13();
        System.out.println(mc.movingCount(m,n,k));
    }
}
