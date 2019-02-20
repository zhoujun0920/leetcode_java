class Solution {
  public int removeDuplicates(int[] nums) {
    int n = nums.length;
    if (n <= 2) {
      return n;
    }
    int start = 0;
    int end = 0;
    int count = 1;
    while (end < n) {
      while (nums[start] == nums[end]) {
        end++;
        if (end >= n) {
          return ++start;
        }
        if (nums[end - 1] == nums[end] && count < 2) {
          start++;
          nums[start] = nums[end];
          count = 2;
        }
      }
      start++;
      nums[start] = nums[end];
      count = 1;
    }
    return ++start;
  }
}
