package QaDay;

import java.util.*;

public class MedianFinder295 {
    //直接用List的sort会超时
    //优先队列提供两个最基本的操作，一个是返回最高优先级对象，一个是添加新对象
    //PriorityQueue中放置的元素必须要能够比较大小
    //不能放null,插入和删除元素的时间复杂度均为 O(log2N)
    //PriorityQueue当中，默认最小的元素就是优先级最高的元素,每次peek最小的
    //一般用来实现堆数据结构
    public PriorityQueue<Integer> Minqueue;
    public PriorityQueue<Integer> Maxqueue;
    /** initialize your data structure here. */
    public MedianFinder295() {
        //peek出来的是最大值,Minqueue中的元素都小于等于中位数，所以如果n是奇数Min会比Max多一个数
        Minqueue = new PriorityQueue<>((a,b) -> (b-a));//实现大顶堆，堆顶是最大元素
        //peek出来的是最小值
        Maxqueue = new PriorityQueue<>((a,b) -> (a-b));//默认是小顶堆

    }

    public void addNum(int num) {
        //如果Num<=Max(Minqueue)放Min里面
        //新的中位数将小于等于原来的中位数，因此我们可能需要将Minqueue 中最大的数移动到Maxqueue
        if(Minqueue.isEmpty()||num<=Minqueue.peek()){
            Minqueue.offer(num);
            if(Minqueue.size()>Maxqueue.size()+1){
                Maxqueue.offer(Minqueue.poll());
            }
        }else{//Num>Max(Minqueue)放Max
            Maxqueue.offer(num);
            if(Minqueue.size()<Maxqueue.size()){
                Minqueue.offer(Maxqueue.poll());
            }
        }


    }

    public double findMedian() {
        if(Minqueue.size()>Maxqueue.size())
            return Minqueue.peek();
        double res = (Minqueue.peek()+Maxqueue.peek())/2.0;
        return res;
    }
}
