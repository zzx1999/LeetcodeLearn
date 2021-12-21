package Stackandqueue;

import java.util.Map;
import java.util.Stack;

public class largestRectangleAreaoff039 {
    public int largestRectangleArea(int[] heights) {
        //单调栈保存柱子在数组内的下标值
        //扫描数组如果当前数组高度大于栈顶，柱子下标入栈
        //反之出栈，计算栈顶柱子为顶的最高矩阵面积
        Stack<Integer> hindex = new Stack<>();
        int p = 0,maxres = 0;
        hindex.add(-1);
        while (p<heights.length){
            if (hindex.peek()==-1||heights[p]>=heights[hindex.peek()]){
                hindex.add(p);//直接入栈
            }
            else{
                while (hindex.peek()!=-1&&heights[p]<heights[hindex.peek()]){
                    int top = hindex.pop();
                    maxres = Math.max(maxres,heights[top]*(p-hindex.peek()-1));//计算以栈顶下标对应的柱子为基准的最大高度（右边第一个比它矮的-左边第一个比他矮的-1）
                }
                hindex.add(p);
            }
            p++;
        }
        //栈中还有元素，再加入一个高度为0的柱子
        while (hindex.peek()!=-1){
            int top = hindex.pop();
            maxres = Math.max(maxres,heights[top]*(heights.length-hindex.peek()-1));
        }
        return maxres;

    }

    public static void main(String[] args) {
        int[] height = {2,4};
        largestRectangleAreaoff039 lra = new largestRectangleAreaoff039();
        lra.largestRectangleArea(height);
    }
}
