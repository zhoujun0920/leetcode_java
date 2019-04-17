class Solution {

    int m = 0;
    int n = 0;

    public int maxKilledEnemies(char[][] grid) {
      m = grid.length;
      if (m == 0) {
        return 0;
      }
      n = grid[0].length;
      if (n == 0) {
        return 0;
      }
      int result = 0;
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (grid[i][j] == '0') {
            int temp = helper(grid, i, j);
            result = result > temp ? result : temp;
          }
        }
      }
      return result;
    }

    private int helper(char[][] grid, int i, int j) {
      int result = 0;
      for (int k = i + 1; k < m; k++) {
        if (grid[k][j] == 'W') {
          break;
        } else if (grid[k][j] == 'E') {
          result++;
        }
      }
      for (int k = i - 1; k >= 0; k--) {
        if (grid[k][j] == 'W') {
          break;
        } else if (grid[k][j] == 'E') {
          result++;
        }
      }
      for (int k = j + 1; k < n; k++) {
        if (grid[i][k] == 'W') {
          break;
        } else if (grid[i][k] == 'E') {
          result++;
        }
      }
      for (int k = j - 1; k >= 0; k--) {
        if (grid[i][k] == 'W') {
          break;
        } else if (grid[i][k] == 'E') {
          result++;
        }
      }
      return result;
    }
}
