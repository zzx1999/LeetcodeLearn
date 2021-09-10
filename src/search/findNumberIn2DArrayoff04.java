package search;

public class findNumberIn2DArrayoff04 {
    //线性查找
    //从二维数组的右上角开始查找。如果当前元素等于目标值，则返回 true。
    // 如果当前元素大于目标值，则移到左边一列。如果当前元素小于目标值，则移到下边一行。
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length==0)
            return false;
        int i = 0,j = matrix[0].length-1;
        while (i<matrix.length&&j>=0){
            if(matrix[i][j] == target)
                return true;
            else if(matrix[i][j]>target){
                j--;
            }
            else
                i++;
        }
        return false;
    }
    //每行二分查找O(n^2logn)
    public int binarysearch(int l,int r,int target,int[] arr){
        int low = l,high = r,mid = 0;
        while (low<high){
            mid = low + (high-low)/2;
            if(arr[mid]<target){
                low = mid+1;
            }
            else
                high = mid;
        }
        return --low;
    }

    public static void main(String[] args) {
        int[] test = {1,   4,  7, 11, 15};
        findNumberIn2DArrayoff04 fr = new findNumberIn2DArrayoff04();
        System.out.println(fr.binarysearch(0,4,5,test));
    }
}
