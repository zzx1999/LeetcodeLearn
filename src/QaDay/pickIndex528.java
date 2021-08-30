package QaDay;

import java.util.Arrays;
import java.util.Random;

public class pickIndex528 {
    public int[] w;
    public int total = 0;
    public int[] pre;
    public pickIndex528(int[] w){
        this.w = w;
        int n = w.length;
        pre = new int[n];
        pre[0] = w[0];
        //前缀和pre[i]表示的就是下标i的右边界
        //所以左边界就是pre[i] - w[i] + 1
        for (int i=1;i<w.length;i++){
            pre[i] += pre[i-1]+w[i];
        }
        total = Arrays.stream(w).sum();
    }
    //超出内存限制
    // w 的权重之和为 total
    // 。根据题目的要求，我们可以看成将 [1,total]
    // 范围内的所有整数分成 n 个部分（其中 n 是数组 w 的长度），
    // 第 i 个部分恰好包含 w[i] 个整数，
    // 并且这 n 个部分两两的交集为空。
    public int pickIndex_out(){
        int n = w.length;
        double sum = Arrays.stream(w).sum();
        int[] realval = new int[(int)sum];
        int index = 0;
        for(int i = 0;i<realval.length;){
            for(int j = i;j<w[index]+i;j++){
                realval[j] = index;
            }
            i += w[index];
            index++;
        }
        Random r = new Random();
        int rp = r.nextInt((int)sum);
        return realval[rp];

    }
    //前缀和改进
    //每个区间的左边界是在它之前出现的所有元素的和加上 1
    //右边界是到它为止的所有元素的和。
    //第 i 个区间的左边界就是前缀和i-w[i]+1,右边界就是前缀和i
    //划分完成后，假设我们随机到了整数 x，我们希望找到满足：
    //
    //pre[i]−w[i]+1≤x≤pre[i]
    //pre[i]单调递增
    public int pickIndex(){
        Random r = new Random();
        int x = (int) (Math.random() * total) + 1;//随机一个x看x在哪个区域内
        int l = 0, R = w.length-1,mid;
        while (l<R){
            mid = l + (R-l)/2;
            if(x>pre[mid]){
                l = mid+1;
            }
            else
                R = mid;
        }
        return l;
    }



    public static void main(String[] args) {
        int[] w = {1,3};
        pickIndex528 pi = new pickIndex528(w);
        pi.pickIndex();
    }
}
