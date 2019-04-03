class Solution {
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;
      if (m == n && m == 1) {
          return obstacleGrid[0][0] == 1 ? 0 : 1;
      }
      if (obstacleGrid[0][0] == 1) {
          obstacleGrid[0][0] = -1;
      }
    for (int i = 1; i < m; i++) {
      if (obstacleGrid[i][0] == 1) {
        obstacleGrid[i][0] = -1;
      } else {
         if (obstacleGrid[i - 1][0] == -1) {
          obstacleGrid[i][0] = -1;
         } else {
          obstacleGrid[i][0] = 1;
         }
      }
    }
    for (int j = 1; j < n; j++) {
      if (obstacleGrid[0][j] == 1) {
        obstacleGrid[0][j] = -1;
      } else {
         if (obstacleGrid[0][j - 1] == -1) {
          obstacleGrid[0][j] = -1;
         } else {
          obstacleGrid[0][j] = 1;
         }
      }
    }
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (obstacleGrid[i][j] == 1) {
          obstacleGrid[i][j] = -1;
        } else {
          int l = obstacleGrid[i - 1][j] == -1 ? 0 : obstacleGrid[i - 1][j];
          int u = (obstacleGrid[i][j - 1] == -1 ? 0 : obstacleGrid[i][j - 1]);
          obstacleGrid[i][j] = l + u;
        }
      }
    }
    return obstacleGrid[m - 1][n - 1] == -1 ? 0 : obstacleGrid[m - 1][n - 1];
  }
}

// no need to set block cell.
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int R = obstacleGrid.length;
        int C = obstacleGrid[0].length;

        // If the starting cell has an obstacle, then simply return as there would be
        // no paths to the destination.
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        // Number of ways of reaching the starting cell = 1.
        obstacleGrid[0][0] = 1;

        // Filling the values for the first column
        for (int i = 1; i < R; i++) {
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1) ? 1 : 0;
        }

        // Filling the values for the first row
        for (int i = 1; i < C; i++) {
            obstacleGrid[0][i] = (obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 1) ? 1 : 0;
        }

        // Starting from cell(1,1) fill up the values
        // No. of ways of reaching cell[i][j] = cell[i - 1][j] + cell[i][j - 1]
        // i.e. From above and left.
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if (obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                } else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }

        // Return value stored in rightmost bottommost cell. That is the destination.
        return obstacleGrid[R - 1][C - 1];
    }
}
