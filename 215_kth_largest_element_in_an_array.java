class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}

class Solution {
    public int findKthLargest(int[] nums, int k) {
      quickSort(nums, 0, end - 1);
      return nums[nums.length - k];
    }

    private void quickSort(int[] nums, int start, int end) {
      int p = partition(nums, start, end);
      quickSort(nums, start, p - 1);
      quickSort(nums, p + 1, end);
    }

    private int partition(int[] nums, int start, int end) {
      int pivot = nums[end];
      int i = start
      for (int j = start + 1; i < end; i++) {
        if (nums[j] < pivot) {
          int temp = nums[j];
          nums[j] = nums[i];
          nums[i] = temp;
          i++;
        }
      }
      nums[end] = nums[i];
      nums[i] = pivot;
      return i;
    }
}

// Heap
class Solution {
    public int findKthLargest(int[] nums, int k) {
      PriorityQueue<Integer> queue = new PriorityQueue<>();
      for (int i : nums) {
        queue.add(i);
        if (queue.size() > k) {
          queue.poll();
        }
      }
      return queue.poll();
    }
}
