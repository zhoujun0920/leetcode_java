class Solution {
  public int removeElement(int[] nums, int val) {
    if (nums.length == 0) {
      return 0;
    }
    int start = 0;
    int end = nums.length - 1;
    int count = 0;
    while (start <= end) {
      while (nums[start] != val) {
        count++;
        start++;
        if (start > end) {
          return count;
        }
      }
      while (nums[end] == val) {
        end--;
        if (start >= end) {
          return count;
        }
      }
      nums[start] = nums[end];
      start++;
      end--;
        count++;
    }
    return count;
  }
}
