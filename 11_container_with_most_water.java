class Solution {
    public int maxArea(int[] height) {
      int n = height.length;
      int start = 0;
      int end = n - 1;
      int water = 0;
      while (start < end) {
        int h = height[start] > height[end] ? height[end] : height[start];
        water = water > (end - start) * h ? water : (end - start) * h;
        if (height[start] > height[end]) {
          do {
            end--;
            if (start >= end) {
              return water;
            }
          } while(height[end] < height[end + 1]);
        } else {
          do {
            start++;
            if (start >= end) {
              return water;
            }
          } while(height[start] < height[start - 1]);
        }
      }
      return water;
    }
}
