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
    //0 û�з���
    //1 �����˵����ڻ���������ڵݹ�ջ����
    //2 ��ȫ��
    public boolean safedfs(int[][] graph,int[] color,int s){
        if(color[s]>0)
            return color[s]==2;
        color[s] = 1;
        for(int t:graph[s]){
            //���·���ڵ�����һ�����ڻ������ ����false
            if(!safedfs(graph,color,t)){
                return false;
            }
        }
        color[s] = 2;//��ǰ�ȫ
        return true;
    }
}
