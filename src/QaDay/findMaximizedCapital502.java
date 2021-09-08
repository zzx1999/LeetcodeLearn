package QaDay;

import java.util.Arrays;
import java.util.PriorityQueue;

public class findMaximizedCapital502 {
    //超时
    public int findMaximizedCapital_Timeout(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
//        int[] purepro = new int[n];
//        for(int i=0;i<n;i++){
//            purepro[i] = profits[i] - capital[i];
//        }
        int maxpro = 0;
        int proselect = -1;
        while(k>0){
            for(int i=0;i<n;i++){
                //选资本范围内最大利润
                if(capital[i]<=w&&profits[i]>maxpro){
                    maxpro = profits[i];
                    proselect = i;
                }
            }
            if(proselect!=-1){
                k--;
                w += profits[proselect];
                profits[proselect] = 0;//项目不能重复选
                maxpro = 0;
                proselect = -1;
            }
            else
                break;
        }
        return w;
    }
    //利用堆的贪心算法
    //如果不限制次数下我们可以获取的最大利润，只需将所有的项目按照资本的大小进行排序，
    // 依次购入项目 i，同时手中持有的资本增加 profits[i]，直到手中的持有的资本无法启动当前的项目为止。
    //限制k次就是说每次要贪心选择最大利润，在所有投入资本小于等于w的项目中
    //利用大根堆特性，我们将所有能够投资的项目的利润全部压入到堆中，每次从堆中取出最大值，
    // 然后更新手中持有的资本，同时将待选的项目利润进入堆，不断重复上述操作。
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>((x,y)->(y-x));
        int[][] cap_pro = new int[n][2];
        //存储资本利润 O(n)
        for(int i=0;i<n;i++){
            cap_pro[i][0] = capital[i];
            cap_pro[i][1] = profits[i];
        }
        //按资本排序,升序 O(nlogn)
        Arrays.sort(cap_pro,(a,b)->a[0]-b[0]);
        int cur = 0;
        while (k>0){
            k--;
            //把所有资本满足条件的项目加到堆里
            while (cur<n&&cap_pro[cur][0]<=w){
                queue.add(cap_pro[cur][1]);
                cur++;
            }
            if(!queue.isEmpty()){
                w+=queue.poll();
            }
            else
                break;
        }
        return w;
    }
    public static void main(String[] args) {
        int k=3,w = 0;
        int[] profits = {1,2,3};
        int[] captial = {0,1,2};
        findMaximizedCapital502 fmc = new findMaximizedCapital502();
        System.out.println(fmc.findMaximizedCapital(k,w,profits,captial));

    }
}
