class NumMatrix {

    int[][] temp;

    public NumMatrix(int[][] matrix) {
      temp = matrix;
      for (int i = 0; i < matrix.length; i++) {
        for (int j = 1; j < matrix[i].length; j++) {
          matrix[i][j] += matrix[i][j - 1];
        }
      }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
      int sum = 0;
      for (int i = row1; i <= row2; i++) {
        if (col1 == 0) {
          sum += temp[i][col2];
        } else {
          sum += temp[i][col2] - temp[i][col1 - 1];
        }
      }
      return sum;
    }
}


// [
//   [1,2,3,3]
//   [4,5,6,6]
//   [7,8,9,9]
// ]

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
