class Solution {
    List<Integer> result;

      public List<Integer> spiralOrder(int[][] matrix) {
        result = new LinkedList<>();
        if (matrix.length == 0) {
            return result;
        }
        int c = matrix[0].length; // control column size
        for (int i = 0; i < matrix.length - i; i++) {
            if (c - 2 * i > 0) {
                recursive(matrix, i);
            } else {
                break;
            }
        }
        return result;
      }

      private void recursive(int[][] matrix, int k) {
        for (int i = k; i < matrix[k].length - k; i++) {
            result.add(matrix[k][i]);
        }
        int lastColumn = matrix[k].length - k - 1;
        if (lastColumn >= 0) {
            // right column
            for (int i = k + 1; i < matrix.length - k - 1; i++) {
                result.add(matrix[i][lastColumn]);
            }
            int lastRow = matrix.length - k - 1;
            if (lastRow != k && lastRow >= 0) { // top bottom is not same
                //bottom row
                for (int i = lastColumn; i >= k; i--) {
                    result.add(matrix[lastRow][i]);
                }
                // left column
                if (lastColumn != k) { // left and right is not same
                    for (int i = lastRow - 1; i > k; i--) {
                        result.add(matrix[i][k]);
                    }
                }

            }
        }
      }
}
