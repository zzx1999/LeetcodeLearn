package backtrack;

import java.util.LinkedList;
import java.util.Queue;

public class movingCountoff13 {
    public int movingCount(int m, int n, int k) {
        //dfs
//        int[][] board = new int[m][n];
//        return dfs(board,0,0,m,n,k);
        //bfs
        return bfs(m,n,k);

    }
    public int dfs(int[][] board,int i,int j,int m,int n,int k){
        if(i>=m||i<0||j>=n||j<0||checkijk(i,j,k)||board[i][j]==1) return 0;//这个格子不能踩
//        res++;//踩到了这个格子
        board[i][j]=1;
//        res += dfs(board,i+1,j,m,n,k)+dfs(board,i,j+1,m,n,k);//周围可以踩的格子
//        board[i][j] = 0;
        return 1 + dfs(board,i+1,j,m,n,k)+dfs(board,i,j+1,m,n,k);//1+向右可达总数+向下可达总数


    }
    public int bfs(int m,int n,int k){
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});//加入起点0,0
        int res = 0;
        while (!q.isEmpty()){
            int[] cell = q.poll();
            if(cell[0]>=m||cell[0]<0||cell[1]>=n||cell[1]<0||checkijk(cell[0],cell[1],k)||visited[cell[0]][cell[1]])
                continue;//这个单元格不满足条件的情况
            visited[cell[0]][cell[1]] = true;
            res++;
            q.offer(new int[]{cell[0]+1,cell[1]});
            q.offer(new int[]{cell[0],cell[1]+1});
        }
        return res;
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
