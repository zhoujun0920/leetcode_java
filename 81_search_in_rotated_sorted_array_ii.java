// in worst case O(n) not O(logn)
class Solution {
  public int search(int[] nums, int target) {
      if (nums.length == 0) {
          return -1;
      }
      if (nums.length == 1) {
          return nums[0] == target ? 0 : -1;
      }
      int fast = 1;
      int slow = 0;
      while (fast < nums.length) {
          if (nums[slow] > nums[fast]) {
              break;
          }
          slow++;
          fast++;
      }
      if (target < nums[0]) {
          return binarySearch(fast, nums.length - 1, nums, target);
      } else {
          return binarySearch(0, slow, nums, target);
      }
  }

  private int binarySearch(int start, int end, int[] nums, int target) {
      if (start < end) {
          int mid = end - (end - start) / 2;
          if (nums[mid] > target) {
              return binarySearch(start, mid - 1, nums, target);
          } else if (nums[mid] < target) {
              return binarySearch(mid + 1, end, nums, target);
          } else {
              return mid;
          }
      } else if (start > end) {
          return -1;
      } else {
          return nums[start] == target ? start : -1;
      }
  }
}
