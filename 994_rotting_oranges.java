class Solution {
    public int orangesRotting(int[][] grid) {
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    int[] root = {i, j};
                    queue.add(root);
                }
            }
        }
        while (!queue.isEmpty()) {
            Queue<int[]> current = new LinkedList<>();
            while (!queue.isEmpty()) {
                int[] cor = queue.poll();
                if (cor[0] - 1 >= 0 && grid[cor[0] - 1][cor[1]] == 1) {
                    int[] temp = {cor[0] - 1, cor[1]};
                    grid[temp[0]][temp[1]] = 2;
                    current.add(temp);
                }
                if (cor[1] - 1 >= 0 && grid[cor[0]][cor[1] - 1] == 1) {
                    int[] temp = {cor[0], cor[1] - 1};
                    grid[temp[0]][temp[1]] = 2;
                    current.add(temp);
                }
                if (cor[0] + 1 < grid.length && grid[cor[0] + 1][cor[1]] == 1) {
                    int[] temp = {cor[0] + 1, cor[1]};
                    grid[temp[0]][temp[1]] = 2;
                    current.add(temp);
                }
                if (cor[1] + 1 < grid[cor[0]].length && grid[cor[0]][cor[1] + 1] == 1) {
                    int[] temp = {cor[0], cor[1] + 1};
                    grid[temp[0]][temp[1]] = 2;
                    current.add(temp);
                }
            }
            queue.addAll(current);
            if (current.size() > 0) {
                count++;
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return count;
    }
}
