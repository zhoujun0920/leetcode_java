class Solution {
    int m = 0;
    int n = 0;
    int ans = Integer.MAX_VALUE;

    public int kthSmallest(int[][] matrix, int k) {
        m = matrix.length;
        n = matrix[0].length;
        recursive(matrix, 0, 0, 1, k);
        return ans;
    }

    private void recursive(int[][] matrix, int i, int j, int count, int k) {
        if (count == k) {
            ans = ans < matrix[i][j] ? ans : matrix[i][j];
            return;
        }
        if (i + 1 < m) {
            for (int t = 0; t < n; t++) {
                if (matrix[i + 1][t] >= matrix[i][j]) {
                    recursive(matrix, i + 1, t, count + 1, k);
                }
            }
        }
        if (j + 1 < n) {
            recursive(matrix, i, j + 1, count + 1, k);
        }

    }
}

class Solution {

    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] temp = new int[m * n];
        for (int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                temp[i * m + j] = matrix[i][j];
            }
        }
        Arrays.sort(temp);
        return temp[k - 1];
    }

}
