class Solution {
  public int removeDuplicates(int[] nums) {
    int n = nums.length;
    if (n <= 1) {
      return n;
    }
    int start = 0;
    int end = 1;
    while (end < n) {
      while (nums[start] == nums[end]) {
        end++;
        if (end >= n) {
          return ++start;
        }
      }
      start++;
      nums[start] = nums[end];
    }
    return ++start;
  }
}
