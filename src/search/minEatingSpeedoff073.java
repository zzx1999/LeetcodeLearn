package search;

import java.util.Arrays;

public class minEatingSpeedoff073 {
    public int minEatingSpeed(int[] piles, int h) {
        //狒狒的速度肯定需要大于等于 1，同时也要小于等于最大的一堆香蕉数量 max，因为若大于 max 每小时也只能吃一堆，所以更大的速度是没有意义的。
        //速度在【1，Max】
        //二分查找适合的速度
        int l = 1,r = Arrays.stream(piles).max().getAsInt();
        while (l<r){
            int mid = l + (r-l)/2;
            int time = countTime(piles,mid);
            if(time>h){//如果用mid速度所用时间超过了h那么速度应该再快一点在区间【mid,max】之间
                l = mid+1;
            }
//            else if(time==h){//不能直接return 应为在如果在还有香蕉数量少于吃的速度的情况下，速度还可以更小
//                return mid;
//            }
            else{
                if(mid==1||countTime(piles,mid-1)>h){//速度不能再慢了
                    return mid;
                }
                r = mid-1;
            }
        }
        return l;
    }
    public int countTime(int[] piles,int k){
        int t = 0;
        for(int p:piles){
            t += p/k;
            t += (p % k==0?0:1);
        }
        return t;
    }

    public static void main(String[] args) {
        int[] piles = {1,1,1,999999999};
        int h = 10;
        minEatingSpeedoff073 mes = new minEatingSpeedoff073();
        System.out.println(mes.minEatingSpeed(piles,h));
    }
}
