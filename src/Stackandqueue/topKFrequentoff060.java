package Stackandqueue;

import java.util.*;

public class topKFrequentoff060 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> nummap = new HashMap<>();
        for(int n:nums){
            nummap.put(n,nummap.getOrDefault(n,0)+1);
        }
        //基于map排序
//        List<Map.Entry<Integer,Integer>> list = new LinkedList<>();
//        list.addAll(nummap.entrySet());
//        Collections.sort(list,new Comparator<Map.Entry<Integer,Integer>>(){
//            @Override
//            public int compare(Map.Entry<Integer, Integer> o1,Map.Entry<Integer, Integer> o2) {
//                return o2.getValue()- o1.getValue();
//            }
//        });
//        int[] res = new int[k];
//        for(int i=0;i<k;i++){
//            res[i] = list.get(i).getValue();
//        }
        //使用优先队列
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return ints[1]-t1[1];
            }
        });
        for(Map.Entry<Integer,Integer> entry:nummap.entrySet()){
            int n = entry.getKey(),count = entry.getValue();
            if(queue.size()==k){
                if(count>queue.peek()[1]){
                    queue.poll();
                    queue.add(new int[]{n,count});
                }
            }
            else{
                queue.add(new int[]{n,count});
            }
        }
        int[] res = new int[k];
        for(int i=0;i<k;i++){
            res[i] = queue.poll()[0];
        }

        return res;
    }

}
