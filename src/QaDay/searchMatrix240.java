package QaDay;

public class searchMatrix240 {
    //之字形搜索,从[0,n-1]开始搜索默认target在以matrix左下角为左下角,(x,y)为右上角的矩阵里
    //确定右上角的过程
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0,j = matrix[0].length-1;
        while (i< matrix.length&&j>=0){
            int cur = matrix[i][j];
            if(cur>target)
                j--;
            else if(cur<target)
                i++;
            else if(cur==target)
                return true;
        }
        return false;

    }

}
