class Solution {

    int[][] ds = {{1,0},{-1,0},{0,1},{0,-1}};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image.length == 0) {
            return image;
        }
        boolean[][] memo = new boolean[image.length][image[0].length];
        help(image, sr, sc, newColor, image[sr][sc], memo);
        return image;
    }

    private void help(int[][] image, int x, int y, int newColor, int oldColor, boolean[][] memo) {
        if (memo[x][y]) {
            return;
        }
        image[x][y] = newColor;
        memo[x][y] = true;
        for (int[] d : ds) {
            if (isVisit(image, x + d[0], y + d[1], oldColor)) {

                help(image, x + d[0], y + d[1], newColor, oldColor, memo);
            }
        }
    }

    private boolean isVisit(int[][] image, int x, int y, int oldColor) {
        return x >= 0 && x < image.length && y >= 0 && y < image[x].length && image[x][y] == oldColor;
    }
}
