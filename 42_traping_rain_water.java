class Solution {
    public int trap(int[] height) {
      int n = height.length;
      if (n <= 1) {
          return 0;
      }
      int i = 0;
      int j = 1;
      int water = 0;
      while (j < n) {
          int s = Integer.MIN_VALUE;
          while (j < n && height[j] < height[i]) {
              j++;
              if (j == n) {
                  height[i] = s;
                  j = i + 1;
              }
              s = s > height[j] ? s : height[j];
          }
          int h = height[i] > height[j] ? height[j] : height[i];
          int k = i + 1;
          while (k < j) {
              water = water + (h > height[k] ? h - height[k] : 0);
              k++;
          }
          i = j;
          j = i + 1;
      }
      return water;
    }
}

[0,1,0,2,1,0,1,3,2,1,2,1]
[2,1,0,2]
[4,2,3]
[4,9,4,5,3,2]
