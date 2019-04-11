class Solution {

  boolean found = false;
  int m = 0;
  int n = 0;

  public boolean searchMatrix(int[][] matrix, int target) {
    m = matrix.length;
      if (m == 0) {
          return false;
      }
      n = matrix[0].length;
      if (n == 0) {
          return false;
      }
    backtracking(matrix, 0, 0, target);
    return found;
  }

  private void backtracking(int[][] matrix, int i, int j, int target) {
    if (!found && i < m && j < n) {
        if (matrix[i][j] == target) {
          found = true;
        }
        if (j + 1 < n && matrix[i][j + 1] <= target) {
          backtracking(matrix, i, j + 1, target);
        }
        if (i + 1 < m && matrix[i + 1][j] <= target) {
          backtracking(matrix, i + 1, j, target);
        }
    }
  }
}

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
      int m = matrix.length;
      if (m == 0) {
        return false;
      }
      int n = matrix[0].length;
      if (n == 0) {
        return false;
      }
      for (int i = 0; i < m; i++) {
        if (matrix[i][0] > target) {
          return false;
        }
        if (binary(matrix, target, 0, n - 1, i)) {
          return true;
        }
      }
      return false;
    }

    private boolean binary(int[][] matrix, int target, int start, int end, int r) {
      if (start <= end) {
        int mid = start + (end - start) / 2;
        if (matrix[r][mid] == target) {
          return true;
        }
        if (matrix[r][mid] < target) {
          return binary(matrix, target, mid + 1, end, r);
        } else {
          return binary(matrix, target, start, mid - 1, r);
        }
      }
      return false;
    }
}

// Iterate diagonals
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

    }

    private boolean binary(int[][] matrix, int target, int start, int end, int r) {
      
    }
}
