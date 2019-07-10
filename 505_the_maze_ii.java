class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if (maze.length == 0 || maze[0].length == 0) {
            return 0;
        }
        int[][] memo = new int[maze.length][maze[0].length];
        for (int[] row : memo) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        memo[start[0]][start[1]] = 0;
        help(maze, start, memo);
        return memo[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : memo[destination[0]][destination[1]];
    }

    private void help(int[][] maze, int[] start, int[][] memo) {
        int[][] ds = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int originSteps = memo[start[0]][start[1]];
        for (int[] d : ds) {
            int steps = 0;
            int[] next = {start[0] + d[0], start[1] + d[1]};
            while (isValid(maze, next)) {
                next[0] += d[0];
                next[1] += d[1];
                steps++;
            }
            next[0] -= d[0];
            next[1] -= d[1];
            if (originSteps + steps < memo[next[0]][next[1]]) {
                memo[next[0]][next[1]] = originSteps + steps;
                help(maze, next, memo);
            }
        }
    }

    private boolean isValid(int[][] maze, int[] start) {
        return start[0] >= 0 && start[1] >= 1 && start[0] < maze.length && start[1] < maze[0].length && maze[start[0]][start[1]] == 0;
    }
}


class Solution {

    int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int r = maze.length;
        int c = maze[0].length;
        int[][] memo = new int[r][c];
        for (int[] row: memo)
            Arrays.fill(row, Integer.MAX_VALUE);
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        memo[start[0]][start[1]] = 0;
        while (!queue.isEmpty()) {
            int[] cor = queue.poll();
            int dis = memo[cor[0]][cor[1]];

            for (int[] d : directions) {
              int[] next = {cor[0] + d[0], cor[1] + d[1]};
              int step = 0;
              while (canVisit(maze, next, r, c)) {
                next[0] += d[0];
                next[1] += d[1];
                step++;
              }
              next[0] -= d[0];
              next[1] -= d[1];

              if (dis + step < memo[next[0]][next[1]]) {
                queue.add(next);
                memo[next[0]][next[1]] = dis + step;
              }
            }
        }
        return memo[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : memo[destination[0]][destination[1]];
    }

    private boolean canVisit(int[][] maze, int[] start, int r, int c) {
          int x = start[0];
          int y = start[1];
          if (x >= 0 && x < r && y >= 0 && y < c && maze[x][y] != 1) {
            return true;
          }
          return false;
    }
}
// O(mn * max(m,n))
