package Stackandqueue;

import java.util.Arrays;
import java.util.Map;
import java.util.Stack;

public class maximalRectangleoff040 {
    public int maximalRectangle(String[] matrix) {
        //等价于前面的直方图问题
        //以矩阵第一行为底的最大矩阵面积，等效于前一题中的直方图数组为 [1, 0, 1, 0, 0]；以第二行等效为 [2, 0, 2, 1, 1]
        int maxres = 0;
        int n = matrix.length;
        int[] arr;
        if(n!=0) arr=new int[matrix[0].length()];
        else return 0;
        for(String s:matrix){
            String[] tmp = s.split("");
            for (int i=0;i<tmp.length;i++){
                if(tmp[i].equals(0)){
                    arr[i] = 0;
                }
                else
                    arr[i] += Integer.parseInt(tmp[i]);
            }
            maxres = Math.max(maxres,largestRec(arr));
        }
        return maxres;
    }
    public int largestRec(int[] height){
        Stack<Integer> hst = new Stack<>();
        hst.push(-1);
        int maxArea = 0;
        int p = 0;
        while (p<height.length){
            while (hst.peek()!=-1&&height[p]<=height[hst.peek()]){
                int h = height[hst.peek()];
                hst.pop();
                maxArea = Math.max(maxArea,h * (p-hst.peek()-1));
            }
            hst.push(p);
            p++;
        }
        while (hst.peek()!=-1){
            int h = height[hst.peek()];
            hst.pop();
            maxArea = Math.max(maxArea,h * (height.length-hst.peek()-1));
        }
        return maxArea;
    }

    public static void main(String[] args) {
        String[] matrix = {"01","10"};
        maximalRectangleoff040 mR = new maximalRectangleoff040();
        mR.maximalRectangle(matrix);
    }
}
