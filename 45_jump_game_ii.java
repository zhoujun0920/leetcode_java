class Solution {
    public int jump(int[] nums) {
      int n = nums.length;
      int i = n - 1;
      int count = 0;
      while (i >0) {
        for (int j = 0; j < n; j++) {
          if (nums[j] + j >= i) {
            count++;
            i = j;
            break;
          }
        }
      }
      return count;
    }
}
