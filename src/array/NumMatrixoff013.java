package array;

public class NumMatrixoff013 {
    int[][] prexMatrix;
    int[][] matrix;
    public NumMatrixoff013(int[][] matrix) {
        //计算每一行前缀和
        this.matrix = matrix;
        int n = matrix.length;
        int m = 0;
        if(n!=0) m = matrix[0].length;
        prexMatrix = new int[n][m];
        for(int i=0;i<n;i++){
            int preSum = 0;
            for(int j = 0;j<m;j++){
                preSum += matrix[i][j];
                prexMatrix[i][j] = preSum;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int i=row1;i<=row2;i++){
            sum += (prexMatrix[i][col2]-prexMatrix[i][col1]+matrix[i][col1]);//每一行前缀和逐行相加
        }
        return sum;
    }
}
