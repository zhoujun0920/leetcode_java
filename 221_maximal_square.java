class Solution {

    int count;

    public int maximalSquare(char[][] matrix) {
        count = 0;
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                squareCount(matrix, i, j, m, n);
            }
        }
        return count;
    }
    private void squareCount(char[][] matrix, int i, int j, int m, int n) {
        int num = 0;
        for (int k = 0; k < (m - i < n - j ? m - i : n - j); k++) {
            for (int x = i; x <= i + k; x++) {
                for (int y = j; y <= j + k; y++) {
                    if (matrix[x][y] == '1') {
                        num++;
                    } else {
                        return;
                    }
                }
            }
            count = count > num ? count : num;
            num = 0;
        }
    }
}


// DP

class Solution {
    public int maximalSquare(char[][] matrix) {
      int m = matrix.length;
      if (m == 0) {
          return 0;
      }
      int count = 0;
      int n = matrix[0].length;
      int[][] temp = new int[m][n];
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (i == 0 || j == 0) {
            temp[i][j] = matrix[i][j] - '0';
          } else {
            if (matrix[i][j] == '1') {
              temp[i][j] = Math.min(Math.min(temp[i - 1][j], temp[i][j - 1]), temp[i - 1][j - 1]) + 1;
            }
          }
          count = count > temp[i][j] ? count : temp[i][j];
        }
      }
      return count * count;
    }
}
