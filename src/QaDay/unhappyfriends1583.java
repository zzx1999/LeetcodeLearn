package QaDay;

import java.util.HashMap;
import java.util.Map;

public class unhappyfriends1583 {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int[][] order = new int[n][n];
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n-1;j++){
                int preference = preferences[i][j];
                order[i][preference] = j;
            }
        }
        int[] match = new int[n];
        for(int i=0;i<pairs.length;i++){
            match[pairs[i]
                    [0]] = pairs[i][1];
            match[pairs[i]
                    [1]] = pairs[i][0];
        }
        for(int i = 0;i<n;i++){
            int x = i;
            int y = match[x];
            int index = order[x][y];//y在x的喜爱度排名
            for(int j = 0;j<index;j++){//x喜爱度里面排在y前面的
                int u = preferences[x][j];
                int v = match[u];
                if(order[u][x]<order[u][v]) {
                    count++;
                    break;//这就已经可以判定x不开心了
                }

            }
        }
        System.out.print(count);
        return count;

    }

    //这个不行，逻辑鬼才盘半天盘不清楚
    public int unhappyFriends_wrong(int n, int[][] preferences, int[][] pairs) {
        int pairlen = pairs.length;
        int count = 0;
        Map<Integer,HashMap<Integer,Integer>> premap = new HashMap<>();
        for(int i=0;i<n;i++){
            HashMap<Integer,Integer> map = premap.getOrDefault(i,new HashMap<Integer,Integer>());
            int score = n-1;
            for(int preindex:preferences[i]){
                map.put(preindex,score);
                score--;
            }
            premap.put(i,map);
        }
        for(int i = 0;i<pairlen;i++){
            int x = pairs[i][0];
            int y = pairs[i][1];
            int xtoy = premap.get(x).get(y),ytox = premap.get(y).get(x);
//            for(int likeidex:preferences[x]){
//                if(likeidex==y){
//                    xtoy = likeidex;
//                }
//            }
//            for(int likeidx:preferences[y]){
//                if(likeidx==x)
//                    ytox = likeidx;
//            }
            for(int j = 0;j<pairlen;j++){
                if(j==i)
                    continue;
                int u = pairs[j][0];
                int v = pairs[j][1];
                int xflag = 0,yflag = 0;
                int xtou = premap.get(x).get(u),utov = premap.get(u).get(v),utox = premap.get(u).get(x),ytou = premap.get(y).get(u),utoy = premap.get(u).get(y);
                int xtov = premap.get(x).get(v),vtou = premap.get(v).get(u),vtox = premap.get(v).get(x),ytov = premap.get(y).get(v),vtoy = premap.get(v).get(y);
                if(xtou>xtoy&&utox>utov&&xflag==0){
                    count++;
                    xflag++;
//                    break;
                }
                if(xtov>xtoy&&vtox>vtou&&xflag==0){
                    count++;
                    xflag++;
//                    break;
                }
                if(ytou>ytox&&utoy>utov&&yflag==0){
                    count++;
                    yflag++;
//                    break;
                }

                if(ytov>ytox&&vtoy>vtou&&yflag==0){
                    count++;
                    yflag++;
//                    break;
                }
            }
        }
        System.out.print(count);
        return count;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] preferences = {{1,2,3},{3,2,0},{3,1,0},{1,2,0}};
        int[][] pairs = {{0,1},{2,3}};
        unhappyfriends1583 uf = new unhappyfriends1583();
        uf.unhappyFriends(n,preferences,pairs);
    }
}
