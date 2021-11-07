package Stackandqueue;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class maxSlidingWindowoff59_1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((x,y)->y[0]-x[0]);
        int n = nums.length;
        if(n==0)
            return new int[0];
        int[] pair = new int[2];
        for(int i=0;i<(k>n?n:k);i++){
            queue.add(new int[]{nums[i],i});
        }
        int index = k;
        int maxres = queue.peek()[0];
        List<Integer> ans = new LinkedList<>();
        ans.add(maxres);
        while (index<n){
            queue.add(new int[]{nums[index],index});
            int[] maxpair = queue.peek();
            while(maxpair[1]<index-k+1){//如果最大值在滑动窗口左边
                queue.poll();
                maxpair = queue.peek();
            }
//            maxres = Math.max(maxres,maxpair[0]);
            ans.add(maxpair[0]);
            index++;

        }
        return ans.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        int[] num = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        maxSlidingWindowoff59_1 mw = new maxSlidingWindowoff59_1();
        mw.maxSlidingWindow(num,k);
    }
}
