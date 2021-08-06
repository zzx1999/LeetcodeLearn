package QaDay;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class shortestPath {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        Queue<int[]> queue = new LinkedList<int[]>();
        int[][] visited = new int[n][1<<n];
        for(int i =0;i<n;i++){
            queue.offer(new int[]{i,1<<i,0});
            visited[i][1<<i] = 1;
        }
        int step = 0;
        while(!queue.isEmpty()){
            int[] truple = queue.poll();
            int node = truple[0], mask = truple[1],dis = truple[2];
            if(mask==((1<<n)-1)){
                step = dis;
                break;
            }
            //搜索相邻节点
            for(int adjnode : graph[node]){
                //// 将 mask 的第 adjnode 位置置为 1
                int nextmask = mask|(1<<adjnode);
                if(visited[adjnode][nextmask]!=1){
                    visited[adjnode][nextmask] = 1;
                    int[] newtruple = new int[]{adjnode,nextmask,dis+1};
                    queue.offer(newtruple);
                }
            }
        }
        return step;

    }
}
