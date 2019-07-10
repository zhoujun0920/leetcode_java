class Solution {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> result = new LinkedList<>();
        if (matrix.length == 0) {
            return result;
        }
        if (matrix[0].length == 0) {
            return result;
        }
        boolean[][] memo = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int[] start = {i, j};
                if (help(matrix, start, new Boolean[matrix.length][matrix[0].length], new boolean[2], memo)) {
                    memo[i][j] = true;
                    result.add(start);
                }
            }
        }
        return result;
    }

    private boolean help(int[][] matrix, int[] start, Boolean[][] visited, boolean[] reached, boolean[][] memo) {
        if (memo[start[0]][start[1]]) {
            return true;
        }
        if (visited[start[0]][start[1]] != null) {
            return false;
        }
        visited[start[0]][start[1]] = false;
        if (start[0] == 0 || start[1] == 0) {
            reached[0] = true;
        }
        if (start[0] == matrix.length - 1 || start[1] == matrix[0].length - 1) {
            reached[1] = true;
        }
        if (reached[0] && reached[1]) {
            return true;
        }
        int[][] ds = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] d : ds) {
            int[] next = {start[0] + d[0], start[1] + d[1]};
            if (isVisit(matrix, next, visited) && matrix[start[0]][start[1]] >= matrix[next[0]][next[1]]) {
                if (help(matrix, next, visited, reached, memo)) {
                    return true;
                }
            }
        }
        return visited[start[0]][start[1]] = false;
    }

    private boolean isVisit(int[][] matrix, int[] start, Boolean[][] visited) {
        return start[0] >= 0 && start[1] >= 0 && start[0] < matrix.length && start[1] < matrix[0].length && (visited[start[0]][start[1]] == null || visited[start[0]][start[1]]);
    }
}
