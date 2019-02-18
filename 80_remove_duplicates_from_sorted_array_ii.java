class Solution {
  public int removeDuplicates(int[] nums) {
    int n = nums.length;
    if (n <= 2) {
      return n;
    }
    int start = 0;
    int end = 1;
    int count = 1;
    while (end < n) {
      while (nums[start] == nums[end]) {
        end++;
        if (end >= n) {
          return ++start;
        }
        if (count < 2) {
          start++;
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
0,0,1,1,1,1,2,3,3
0,0,1,1,2,1,2,3,3
0,0,1,1,2,3,2,3,3
