package BFS;

import java.util.*;

public class openlock {
    //向下拨动一次
    public String plusOne(String s,int i){
        char[] c = s.toCharArray();
        if(c[i] == '9')
            c[i] = '0';
        else
            c[i] += 1;
        return new String(c);

    }
    //向上拨动
    public String minusOne(String s,int i){
        char[] c = s.toCharArray();
        if(c[i] == '0')
            c[i] = '9';
        else
            c[i] -= 1;
        return new String(c);
    }
    //BFS
    public int openLock(String[] deadends, String target) {
        Queue<String> q = new LinkedList<String>();
        q.offer("0000");
        //记录已经经过的节点
        List<String> visited = new LinkedList<String>();
        visited.add("0000");
        List<String> deadlist = Arrays.asList(deadends);
        System.out.println(deadlist);
        int step = 0;
        while (!q.isEmpty()){
            int size = q.size();
            //从当前队列中的所有节点向周围遍历
            for(int i=0;i<size;i++){
                String cur = q.poll();
                //判断是否终止
                if(deadlist.contains(cur))
                    continue;
                if(cur.equals(target))
                    return step;
                //把每个节点的相邻节点加入队列
                for(int j=0;j<4;j++){
                    String nextplus = plusOne(cur,j);
                    if(!visited.contains(nextplus)){
                        q.offer(nextplus);
                        visited.add(nextplus);
                    }
                    String nextminus = minusOne(cur,j);
                    if(!visited.contains(nextminus)){
                        q.offer(nextminus);
                        visited.add(nextminus);
                    }
                }
            }
            step++;
        }
        return -1;
    }
    //双向BFS
    int openLock2(String[] deadends, String target) {
        Set<String> q1 = new HashSet<>();
        q1.add("0000");
        Set<String> q2 = new HashSet<>();
        q2.add(target);
        //记录已经经过的节点
        List<String> visited = new LinkedList<String>();
        List<String> deadlist = Arrays.asList(deadends);
        System.out.println(deadlist.size());
        int step = 0;
        while (!q1.isEmpty()&&!q2.isEmpty()){
            // 哈希集合在遍历的过程中不能修改，用 temp 存储扩散结果
            Set<String> temp = new HashSet<>();
            //从起点开始扩散
            for(String cur:q1){
                if(deadlist.contains(cur))
                    continue;
                if(q2.contains(cur))
                    return step;
                visited.add(cur);
                //把每个节点的相邻节点加入队列
                for(int j=0;j<4;j++){
                    String nextplus = plusOne(cur,j);
                    if(!visited.contains(nextplus)){
                        temp.add(nextplus);
                    }
                    String nextminus = minusOne(cur,j);
                    if(!visited.contains(nextminus)){
                        temp.add(nextminus);
                    }
                }

            }
            step++;
            //交换q1 q2下一轮扩散q2
            q1 = q2;
            q2 = temp;

        }
        return -1;
    }

    public static void main(String[] args) {
        String[] deadends = {"5557","5553","5575","5535","5755","5355","7555","3555","6655","6455","4655","4455","5665","5445","5645","5465","5566","5544","5564","5546","6565","4545","6545","4565","5656","5454","5654","5456","6556","4554","4556","6554"};
        String target = "5555";
        openlock ol = new openlock();
        System.out.println(ol.openLock(deadends,target));
    }

}
