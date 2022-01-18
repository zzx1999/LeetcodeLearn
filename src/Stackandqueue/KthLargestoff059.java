package Stackandqueue;

import java.util.*;
import java.util.stream.Collectors;

public class KthLargestoff059 {
    PriorityQueue<Integer> queue;
    int l = 0;
    public KthLargestoff059(int k, int[] nums) {
        l = k;
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        queue = new PriorityQueue<Integer>(list);
        for (int i=0;i<nums.length-k;i++){
            queue.poll();
        }

    }

    public int add(int val) {
        queue.add(val);
        if(queue.size()>l){
            queue.poll();
        }
//        if(queue.size()<l){
//            queue.add(val);
//        }
//        if(queue.size()!=0&&val>queue.peek()){
//            queue.poll();
//            queue.add(val);
//        }
        return queue.peek();
    }
}
