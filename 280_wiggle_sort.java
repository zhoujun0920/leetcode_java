class Solution {
  public void wiggleSort(int[] nums) {
      quickSort(nums, 0, nums.length - 1);
      int i = 0;
      while (i < nums.length - 1) {
          swape(nums, i, i + 1);
          i += 2;
      }
  }

  private void swape(int[] nums, int i, int j) {
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
  }

  private void quickSort(int[] nums, int start, int end) {
      if (start < end) {
          int temp = partition(nums, start, end);
          quickSort(nums, temp + 1, end);
          quickSort(nums, start, temp - 1);
      }
  }

  private int partition(int[] nums, int start, int end) {
      int pivot = nums[end];
      int j = start;
      for (int i = start; i < end; i++) {
          if (nums[i] < pivot) {
              int temp = nums[i];
              nums[i] = nums[j];
              nums[j] = temp;
              j++;
          }
      }
      int temp = nums[j];
      nums[j] = pivot;
      nums[end] = temp;
      return j;
  }
}

class Solution {
  public void wiggleSort(int[] nums) {
        for(int i = 0; i < nums.length; i++)
            if (i % 2 == 1) {
               if (nums[i-1] > nums[i]) {
                   swap(nums, i);
               }
            } else if (i != 0 && nums[i-1] < nums[i]) {
                swap(nums, i);
            }
    }

    private void swap(int[] nums, int i){
          int tmp=nums[i];
          nums[i]=nums[i-1];
          nums[i-1]=tmp;
    }
}
