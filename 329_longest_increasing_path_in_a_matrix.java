// using memo matrix to remember if the spot has been visited
class Solution {
    int m = 0;
    int n = 0;
    int ans = 1;
    int memo[][];

    public int longestIncreasingPath(int[][] matrix) {
      m = matrix.length;
      if (m == 0) {
        return 0;
      }
      n = matrix[0].length;
      memo = new int[m][n];
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          int temp = recursive(matrix, i, j, Integer.MIN_VALUE);
          ans = ans > temp ? ans : temp;
        }
      }
      return ans;
    }

    public int recursive(int[][] matrix, int i, int j, int prev) {
      if (i >= m || j >= n || i < 0 || j < 0 || matrix[i][j] <= prev) {
        return 0;
      }
      if (memo[i][j] != 0) {// to memorize the visited cell
        return memo[i][j];
      }
      int count = 1;
      count = Math.max(count, recursive(matrix, i + 1, j, matrix[i][j]) + 1);
      count = Math.max(count, recursive(matrix, i, j + 1, matrix[i][j]) + 1);
      count = Math.max(count, recursive(matrix, i - 1, j, matrix[i][j]) + 1);
      count = Math.max(count, recursive(matrix, i, j - 1, matrix[i][j]) + 1);
      memo[i][j] = count;
      return count;
    }
}
