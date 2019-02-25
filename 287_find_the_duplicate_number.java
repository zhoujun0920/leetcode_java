// O(n^2)
class Solution {
    public int findDuplicate(int[] nums) {
      for (int i = 0; i < nums.length; i++) {
        for (int j = i + 1; j < nums.length; j++) {
          if (nums[i] == nums[j]) {
            return true;
          }
        }
      }
      return false;
    }
}

// O(nlogn)
// Sort

class Solution {
    public int findDuplicate(int[] nums) {

    }

    private void quickSort(int[] nums, int start, int end) {
      if (start < end) {
        int temp = partition(nums, start, end);
        quickSort(nums, start, temp - 1);
        quickSort(nums, temp + 1, end);
      }
    }

    private int partition(int[] nums, int start, int end) {
      int pivot = nums[end];
      int i = start;
      for (int j = 0; j < end; j++) {
        if (nums[j] < pivot) {
          int temp = nums[i];
          nums[j] = nums[i];
          nums[i] = temp;
          i++;
        }
      }
      int temp = nums[i];
      nums[i] = pivot;
      nums[end] = temp;
      return i;
    }
}

// O(logn)
class Solution {
    public int findDuplicate(int[] nums) {
      int start = 1;
      int end = nums.length - 1;
      while (start < end) {
          int temp = (end + start) / 2;
          int larger = 0;
          int smaller = 0;
          int equals = 0;
          for (int num : nums) {
              if (num > temp && num <= end) {
                  larger++;
              } else if (num < temp && num >= start) {
                  smaller++;
              } else if (num == temp) {
                  equals++;
              }
          }
          if (equals  > 1) {
              return temp;
          }
          if (larger > smaller) {
              start = (end + start) / 2 + 1;
          } else {
              end = (end + start) / 2 - 1;
          }
      }
      return start;
    }
}

// O(n)
// Floyd Tortoise and Hare (Cycle Detection)
class Solution {
    public int findDuplicate(int[] nums) {

    }
}
