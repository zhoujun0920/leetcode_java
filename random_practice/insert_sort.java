class Solution {
  public void insertSort(int[] nums) {
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] < nums[i - 1]) {
        int j = i;
        while (nums[j] < nums[j - 1]) {
          int temp = nums[j];
          nums[j] = nums[j - 1];
          nums[j - 1] = temp;
          j--;
        }
      }
    }
  }
}
