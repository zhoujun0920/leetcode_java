class Solution {
  public void quickSort(int[] nums, int start, int end) {
    if (start < end) {
      int temp = partition(nums, start, end);
      quickSort(nums, start, temp - 1);
      quickSort(nums, temp + 1, end);
    }
  }

  public int partition(int[] nums, int start, int end) {
    int pivot = nums[end];
    int i = start;
    for (int j = start; j < end - 1; j++) {
      if (nums[j] < pivot) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        i++;
      }
    }
    int temp = nums[i];
    nums[i] = pivot;
    nums[end] = temp;
    return i;
  }
}
