// O(n)
class Solution {
    public int findMin(int[] nums) {
        if (nums.length <= 1) {
            return nums[0];
        }
        int fast = 1;
        int slow = 0;
        while (fast < nums.length) {
            if (nums[slow] > nums[fast]) {
                return nums[fast];
            }
            fast++;
            slow++;
        }
        return nums[0];
    }
}

// O(logn)
class Solution {
  public int findMin(int[] nums) {
      if (nums.length == 1) {
          return nums[0];
      }
      int start = 0;
      int end = nums.length - 1;
      if (nums[0] < nums[end]) {
          return nums[0];
      }
      while (start <= end) {
          int mid = end - (end - start) / 2;
          if (nums[mid - 1] > nums[mid]) {
              return nums[mid];
          }
          if (nums[mid] > nums[mid + 1]) {
              return nums[mid + 1];
          }
          if (nums[mid] > nums[0]) {
              start = mid + 1;
          } else {
              end = mid - 1;
          }
      }
      return -1;
  }
}
