package Math;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class spiralOrderoff29 {
    public int[] spiralOrder(int[][] matrix) {
        int n = matrix.length-1;
        if(n==0)
            return new int[0];
        int m = matrix[0].length-1;
        int l=0,r=m,t=0,b=n;//左右上下
        int[] res = new int[(m+1) * (n+1)];
        int index = 0;
        while (l<=r&&t<=b){
            //向右
            for(int p=l;p<=r;p++)
                res[index++] = matrix[t][p];
            //向下
            for(int p=t+1;p<=b;p++)
                res[index++] = matrix[p][r];
            if(l<r&&t<b){
                //向左
                for(int p=r-1;p>=l;p--)
                    res[index++] = matrix[b][p];
                //向上
                for(int p=b-1;p>=t+1;p--){
                    res[index++] = matrix[p][l];
                }
            }

            l++;
            t++;
            r--;
            b--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] martix = {{1,2,3},{4,5,6},{7,8,9}};
        spiralOrderoff29 so = new spiralOrderoff29();
        so.spiralOrder(martix);
    }
}
