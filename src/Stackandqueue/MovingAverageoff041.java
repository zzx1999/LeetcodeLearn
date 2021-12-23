package Stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverageoff041 {
    /** Initialize your data structure here. */
    Queue<Integer> q;
    int size = 0;
    int sum = 0;
    public MovingAverageoff041(int size) {
        this.size = size;
        q = new LinkedList<>();
    }
    public double next(int val) {
        q.offer(val);
        sum += val;
        if(q.size()>size){
            sum -= q.poll();
        }
        int newsize = q.size()>size?size:q.size();
        return (double) sum/newsize;
//        if(q.size()>size){
//            int i = 0;
//            while (i<q.size()-size){//增加时间复杂度了
//                q.poll();
//                i++;
//            }
//        }else{
//            newsize = q.size();
//        }
//        int sum = q.stream().reduce(Integer::sum).orElse(0);
//        double res = (double) sum/newsize;
//        return res;
    }

    public static void main(String[] args) {
        MovingAverageoff041 ma = new MovingAverageoff041(3);
        ma.next(1);
        ma.next(10);
        ma.next(3);
        ma.next(5);

    }
}
