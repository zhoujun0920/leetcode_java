class Solution {
    public int numDistinctIslands(int[][] grid) {
        Set<String> set = new HashSet<>();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] != 0) {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, sb, "o"); // origin
                    grid[i][j] = 0;
                    set.add(sb.toString());
                }
            }
        }
        return set.size();
    }
    private void dfs(int[][] grid, int i, int j, StringBuilder sb, String dir) {
        if(i < 0 || i == grid.length || j < 0 || j == grid[i].length
           || grid[i][j] == 0) return;
        sb.append(dir);
        grid[i][j] = 0;
        dfs(grid, i-1, j, sb, "u");
        dfs(grid, i+1, j, sb, "d");
        dfs(grid, i, j-1, sb, "l");
        dfs(grid, i, j+1, sb, "r");
        sb.append("b"); // back
    }
}



class Solution {
    int[][] grid;
    Set<Integer> shape;

    public void explore(int r, int c, int r0, int c0) {
        if (0 <= r && r < grid.length && 0 <= c && c < grid[0].length &&
                grid[r][c] == 1) {
            grid[r][c] = 0;
            shape.add((r - r0) * 2 * grid[0].length + (c - c0));
            //int hash = (r - r0 + c - c0) * (r - r0 + c - c0 + 1) / 2 + (c - c0);
            //shape.add(hash);
            explore(r+1, c, r0, c0);
            explore(r-1, c, r0, c0);
            explore(r, c+1, r0, c0);
            explore(r, c-1, r0, c0);
        }
    }
    public int numDistinctIslands(int[][] grid) {
        this.grid = grid;
        Set shapes = new HashSet<HashSet<Integer>>();

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                shape = new HashSet<Integer>();
                explore(r, c, r, c);
                if (!shape.isEmpty()) {
                    shapes.add(shape);
                }
            }
        }

        return shapes.size();
    }
}


Solution {

  public int numDistinctIslands(int[][] grid) {
      Set<String> set = new HashSet<>();
      for(int i = 0; i < grid.length; i++) {
          for(int j = 0; j < grid[i].length; j++) {
              if(grid[i][j] != 0) {
                  StringBuilder sb = new StringBuilder();
                  dfs(grid, i, j, sb, "o"); // origin
                  grid[i][j] = 0;
                  set.add(sb.toString());
              }
          }
      }
      return set.size();
  }
  private void dfs(int[][] grid, int i, int j, StringBuilder sb, String dir) {
      if(i < 0 || i == grid.length || j < 0 || j == grid[i].length
         || grid[i][j] == 0) return;
      sb.append(dir);
      grid[i][j] = 0;
      dfs(grid, i-1, j, sb, "u");
      dfs(grid, i+1, j, sb, "d");
      dfs(grid, i, j-1, sb, "l");
      dfs(grid, i, j+1, sb, "r");
      sb.append("b"); // back
  }
}
