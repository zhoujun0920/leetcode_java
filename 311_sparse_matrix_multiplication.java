class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int row = A.length;
        int column = B[0].length;
        int[][] result = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                for (int k = 0, m = 0; k < A[i].length; k++, m++) {
                    result[i][j] += A[i][k] * B[m][j];
                }
            }
        }
        return result;
    }
}
