package QaDay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Safety {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        int n = graph.length;
        int[] color = new int[n];
        for(int i=0;i<n;i++){
            if(safedfs(graph,color,i)){
               res.add(i);
            }
        }
        return res;


    }
    //0 没有访问
    //1 访问了但是在环里面或者在递归栈里面
    //2 安全的
    public boolean safedfs(int[][] graph,int[] color,int s){
        if(color[s]>0)
            return color[s]==2;
        color[s] = 1;
        for(int t:graph[s]){
            //如果路径节点中有一个是在环里面的 返回false
            if(!safedfs(graph,color,t)){
                return false;
            }
        }
        color[s] = 2;//标记安全
        return true;
    }
}
