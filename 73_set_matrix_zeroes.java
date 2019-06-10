// Integer.MIN_VALUE might exists in matrix
class Solution {
    public void setZeroes(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    for (int k = 0; k < matrix[0].length; k++) {
                        matrix[i][k] = matrix[i][k] == 0 ? 0 : Integer.MIN_VALUE;
                    }
                    for (int k = 0; k < matrix.length; k++) {
                        matrix[k][j] = matrix[k][j] == 0 ? 0 : Integer.MIN_VALUE;
                    }
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = matrix[i][j] == Integer.MIN_VALUE ? 0 : matrix[i][j];
            }
        }
    }
}


//[
//  [0,1,2,0],
//  [3,4,5,2],
//  [1,3,1,5]
//]

// O(m +n) space, O(mn) time
class Solution {
  public void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> columns = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    columns.add(j);
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (rows.contains(i) || columns.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}


class Solution {
  public void setZeroes(int[][] matrix) {
    boolean colZero = false;
    for (int i = 0; i < matrix.length; i++) {
      if (matrix[i][0] == 0) {
        colZero = true;
        break;
      }
    }
    for (int i = 1; i < matrix[0].length; i++) {
      if (matrix[0][i] == 0) {
        matrix[0][0] = 0;
      }
    }
    for (int i = 1; i < matrix.length; i++) {
      for (int j = 1; j < matrix[i].length; j++) {
        if (matrix[i][j] == 0) {
          matrix[i][0] = 0;
          matrix[0][j] = 0;
        }
      }
    }
    for (int i = 1; i < matrix.length; i++) {
      for (int j = 1; j < matrix[i].length; j++) {
        if (matrix[i][0] == 0 || matrix[0][j] == 0) {
          matrix[i][j] = 0;
        }
      }
    }
    if (matrix[0][0] == 0) {
      for (int i = 1; i < matrix[0].length; i++) {
          matrix[0][i] = 0;
      }
    }
    if (colZero) {
      for (int i = 0; i < matrix.length; i++) {
          matrix[i][0] = 0;
      }
    }
  }
}
