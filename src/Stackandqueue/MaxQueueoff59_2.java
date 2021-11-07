package Stackandqueue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaxQueueoff59_2 {
    Deque<Integer> d;//维护双端队列确保对首元素最大
    Queue<Integer> q;
    public MaxQueueoff59_2() {
        q = new LinkedList<>();
        d = new LinkedList<>();
    }

    public int max_value() {
        if(q.isEmpty())
            return -1;
        return d.peekFirst();
    }

    public void push_back(int value) {
        while (!d.isEmpty()&&d.peekLast()<value){
            d.pollLast();
        }
        d.offerLast(value);
        q.offer(value);

    }

    public int pop_front() {
        if(q.isEmpty())
            return -1;
        //检查弹出来的是不是最大值
        int ans = q.poll();
        if(ans==d.peekFirst())
            d.pollFirst();
        return ans;
    }
}
