
// TLE
class Solution {

    int count = 0;

    public int uniquePaths(int m, int n) {
      recursive(1, 1, m, n);
      return count;
    }

    private int recursive(int x, int y, int m, int n) {
      if (x == m && y == n) {
        return 1;
      }
      if (x + 1 <= m) {
        return recursive(x + 1, y, m, n);
      }
      if (y + 1 <= n) {
        return recursive(x, y + 1, m, n);
      }
    }
}


// DP
class Solution {
  public int uniquePaths(int m, int n) {
    int[][] matrix = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0) {
          matrix[i][j] = 1;
        }
        if (j == 0) {
          matrix[i][j] = 1;
        }
        if (i != 0 && j != 0) {
          matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
        }
      }
    }
    return matrix[m - 1][n - 1];
  }
}


// Math solution C(m - 1)(m + n - 2) = C(n - 1)(m + n - 2)
class Solution {
  public int uniquePaths(int m, int n) {
   long result = 1;
   for(int i = 0;i < Math.min(m - 1,n - 1); i++)
       result = result * (m + n - 2 - i) / (i + 1);
   return (int)result;
  }
}
