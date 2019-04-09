class Solution {
    public int findPeakElement(int[] nums) {
      return  recursive(nums, 0, nums.length - 1);
    }

    private int recursive(int[] nums, int start, int end) {
      if (start == end) {
        return start;
      }
      int mid = start + (end - start) / 2; // This is important
      if (nums[mid] > nums[mid + 1]) {
        return recursive(nums, start, mid);
      } else {
        return recursive(nums, mid + 1, end);
      }
    }
}

// 0 3 6
// 4 5 6
// 4 4 5
