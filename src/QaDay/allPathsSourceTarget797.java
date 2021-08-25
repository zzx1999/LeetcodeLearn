package QaDay;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class allPathsSourceTarget797 {
    public List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        LinkedList<Integer> r = new LinkedList<>();
        r.add(0);
        dfs(graph,0,r);
        return res;

    }

    public void dfs(int[][] graph, int src, LinkedList<Integer> r){
        int n = graph.length;
        if(src==n-1){
            res.add(new LinkedList<>(r));
            return;
        }
        for(int route : graph[src]){
            if(!r.contains(route)){
                r.add(route);
            }
            dfs(graph,route,r);
            r.removeLast();
        }

    }

    public static void main(String[] args) {
        int[][] graph = {{1,2},{3},{3},{}};
        allPathsSourceTarget797 aps = new allPathsSourceTarget797();
        aps.allPathsSourceTarget(graph);
    }
}
