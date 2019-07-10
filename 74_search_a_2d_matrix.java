//matrix = [
//   [1,   3,  5,  7],
//   [10, 11, 16, 20],
//   [23, 30, 34, 50]
// ]
// target = 3

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
          if (matrix.length == 0 || matrix[0].length == 0)  {
            return false;
          }
          int t = 0;
          int b = matrix.length - 1;
          while (t < b) {
            int mid = t + (b - t) / 2;
            if (matrix[mid][0] < target) {
              t = mid + 1;
            } else if (matrix[mid][0] > target) {
              b = mid - 1;
            } else {
              return true;
            }
          }
          // check if t is greater then b
          if (matrix[t][0] > target) {
            t -= 1;
          }
          // check if is negative
            if (t < 0) {
                return false;
            }
          int l = 0;
          int r = matrix[t].length - 1;
          while (l < r) {
            int mid = l + (r - l) / 2;
            if (matrix[t][mid] < target) {
              l = mid + 1;
            } else if (matrix[t][mid] > target) {
              r = mid - 1;
            } else {
              return true;
            }
          }
          return matrix[t][l] == target;
    }
}

class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
      if (matrix.length == 0 || matrix[0].length == 0) return false;
      int[] col0 = new int[matrix.length];
      for (int i = 0; i < matrix.length; i++) {
          col0[i] = matrix[i][0];
      }
      int r_index = binarySearchloc(col0, 0, col0.length - 1, target);
      int c_index = binarySearchloc(matrix[r_index], 0, matrix[r_index].length - 1, target);
      return matrix[r_index][c_index] == target;
  }

  public int binarySearchloc(int[] nums, int l, int r, int target) {
      if (l >= r) {
          if (nums[l] == target) {
              return l;
          } else if (nums[l] < target) {
              return l;
          } else {
              return l > 0 ? l - 1 : 0;
          }
      }
      int mid = l + (r - l) / 2;
      if (nums[mid] == target) {
          return mid;
      } else if (nums[mid] < target) {
          return binarySearchloc(nums, mid + 1, r, target);
      } else {
          return binarySearchloc(nums, l , mid - 1, target);
      }

  }
}
