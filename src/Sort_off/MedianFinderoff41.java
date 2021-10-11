package Sort_off;

import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinderoff41 {
    Queue<Integer> A,B;
    /** initialize your data structure here. */
    public MedianFinderoff41() {
        A = new PriorityQueue<>((x,y)->(y-x));//A是大顶堆存比中位数要小的元素
        B = new PriorityQueue<>();//B是小顶堆存比中位数要大的数
    }
    public void addNum(int num) {
        //假设如果是偶数中位数就是A,B堆顶元素的平均，如果是奇数，中位数就是B堆顶元素，B元素个数比A多1
        if(A.size()!=B.size()){//数组长度是奇数，假如是【1,2,3】，加入的是4，那么就要把B堆顶元素加到A再把4加到B
            B.add(num);
            A.add(B.poll());
        }
        else{//数组长度是偶数，假如是[-1，-2】，加入的是-3,那么就要-3加到A再把A的堆顶元素加到B
            A.add(num);
            B.add(A.poll());
        }
    }

    public double findMedian() {
        double median = 0;
        if(A.size()!= B.size()){
            median = B.peek();
        }
        else{
            median = (A.peek()+B.peek())/2.0;
        }
        return median;
    }
}
