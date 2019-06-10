class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze.length == 0 || maze[0].length == 0) {
            return true;
        }
        return help(maze, start, destination, new boolean[maze.length][maze[0].length]);
    }

    private boolean help(int[][] maze, int[] start, int[] destination, boolean[][] visited) {
        if (visited[start[0]][start[1]]) {
            return false;
        }
        if (start[0] == destination[0] && start[1] == destination[1]) {
            return true;
        }
        visited[start[0]][start[1]] = true;
        int[][] ds = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] d : ds) {
            int[] next = {start[0] + d[0], start[1] + d[1]};
            while (isValid(maze, next)) {
                next[0] += d[0];
                next[1] += d[1];
            }
            next[0] -= d[0];
            next[1] -= d[1];
            if (isValid(maze, next) && help(maze, next, destination, visited)) {
                return true;
            }
        }
        return false;
    }

    private boolean isValid(int[][] maze, int[] start) {
        return start[0] >= 0 && start[1] >= 0 && start[0] < maze.length && start[1] < maze[0].length && maze[start[0]][start[1]] == 0;
    }
}

class Solution {

    int[][] ds = {{0,1},{1,0},{0,-1},{-1,0}};
    int r;
    int c;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        r = maze.length;
        if (r == 0) {
          return false;
        }
        c = maze[0].length;
        if (c == 0) {
          return false;
        }
        boolean[][] visited = new boolean[r][c];
        return recursive(maze, visited, start, destination);
    }

    private boolean recursive(int[][] maze, boolean[][] visited, int[] start, int[] destination) {
        if (visited[start[0]][start[1]]) {
          return false;
        }
        if (destination[0] == start[0] && destination[1] == start[1]) {
          return true;
        }
        visited[start[0]][start[1]] = true;
        for (int[] d : ds) {
            int[] newPoint = {start[0] + d[0], start[1] + d[1]};
            while (canVisit(maze, visited, newPoint)) {
              newPoint[0] += d[0];
              newPoint[1] += d[1];
            }
            int[] newStart = {newPoint[0] - d[0], newPoint[1] - d[1]};
            if (recursive(maze, visited, newStart, destination)) {
              return true;
            }
        }
        return false;
    }

    private boolean canVisit(int[][] maze, boolean[][] visited, int[] p) {
      int x = p[0];
      int y = p[1];
      if (x >= 0 && x < r && y >= 0 && y < c && !visited[x][y] && maze[x][y] != 1) {
        return true;
      }
      return false;
    }
}
