package Stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

public class RecentCounteroff042 {
    Queue<Integer> q;
    int nums = 0;
    public RecentCounteroff042() {
        q = new LinkedList<Integer>();
    }

    public int ping(int t) {
        q.offer(t);
        nums++;
        while (t-3000>q.peek()){
            nums--;
            q.poll();
        }
        return nums;
    }
}
