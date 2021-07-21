package BFS;

import java.util.LinkedList;
import java.util.Queue;

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
    public int openLock(String[] deadends, String target) {
        Queue<String> q = new LinkedList<String>();
        q.offer("0000");
        while (!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                String cur = q.poll();
                //判断是否终止
                for(int j=0;j<cur.length();j++){
                    String nextplus = plusOne(cur,j);
                    q.offer(nextplus);
                    String nextminus = minusOne(cur,j);
                    q.offer(nextminus);
                }
            }
        }
        return 0;
    }

}
