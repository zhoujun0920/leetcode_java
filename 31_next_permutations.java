// 1. Find the first decreasing Element
// 2. Find the element just larger then it
// 3. Swap them
// 4. Reverse the last part

class Solution {
  public void nextPermutation(int[] nums) {
    for (int i = nums.length - 2; i >= 0; i--) {
      if (nums[i] < nums[i + 1]) {
        for (int j = i + 1; j < nums.length; j++) {
          if (j == nums.length - 1 || nums[j] > nums[i] && nums[j + 1] <= nums[i]) { // be careful about the edge case
            swap(nums, i, j);
            reverse(nums, i + 1);
            return;
          }
        }
          break;
      }
    }
    reverse(nums, 0);
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  private void reverse(int[] nums, int start) {
    int i = start;
    int j = nums.length - 1;
    while (i < j) {
      swap(nums, i, j);
      i++;
      j--;
    }
  }
}
