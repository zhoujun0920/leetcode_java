class Solution {
    int count;

    public int maximalRectangle(char[][] matrix) {
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
        for (int k = 0; k < m - i; k++) {
            for (int l = 0; l < n - j; l++) {
                if ((m - i) * (n - j) < count) {
                  continue;
                }
                boolean isFound = true;
                outerloop:
                for (int x = i; x <= i + k; x++) {
                    for (int y = j; y <= j + l; y++) {
                        if (matrix[x][y] == '1') {
                            num++;
                        } else {
                            isFound = false;
                            break outerloop;
                        }
                    }
                }
                if (isFound && num > count) {
                    count = count > num ? count : num;
                }
                num = 0;
            }
        }
    }
}


class Solution {

    public int maximalRectangle(char[][] matrix) {
      int m = matrix.length;
      if (m == 0) {
          return 0;
      }
      int n = matrix[0].length;
      int[][] temp = new int[m][n];
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (i == 0 || j == 0) {
            temp[i][j] = matrix[i][j] - '0';
          } else {
            
          }
        }
      }
    }
}
