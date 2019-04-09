// max heap
// min heap
// p = (i - 2) / 2
// left = 2 * p + 1
// right = 2* p + 2
// build Heap
// extraction

class Solution {
  public int[] heapSort(int[] nums) {
    sort(nums, nums.length);
    return nums;
  }

  private void heapArray(int[] nums, int n, int i) {
    int temp = i;
    int left = 2 * i + 1;
    int right = 2 * i + 2;
    if (left < n && nums[left] > nums[temp]) {
      temp = left;
    }
    if (right < n && nums[right] > nums[temp]) {
      temp = right;
    }
    if (temp != i) {
      int t = nums[temp];
      nums[temp] = i;
      nums[i] = t;
      heapArray(nums, n, temp);
    }
  }

  private void sort(int[] nums, int n) {
    for (int i = (n - 1) / 2; i >= 0; i--) {
      heapArray(nums, n, i);
    }
    for (int i = n - 1; i >= 0; i--) {
      int temp = nums[0];
      nums[0] = nums[i];
      nums[i] = temp;
      heapArray(nums, i, 0);
    }
  }
}
