// Super slow
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        quickSort(nums, 0, nums.length - 1);
        int count = 1;
        int temp = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                continue;
            }
            if (nums[i - 1] == nums[i] - 1) {
                temp++;
            } else {
                temp = 1;
            }
            count = count > temp ? count : temp;
        }
        return count;
    }

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
        for (int j = start; j < end; j++) {
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

//Still not good enough, not O(n)
class Solution {
    public int longestConsecutive(int[] nums) {
      if (nums.length == 0) {
        return 0;
      }
      TreeSet<Integer> s = new TreeSet<>();
      for (int i : nums) {
        s.add(i);
      }
      int count = 1;
      int temp = 1;
      int previous = s.pollFirst();
      while (s.size() > 0) {
        int current = s.pollFirst();
        if (current == previous + 1) {
          temp++;
        } else {
          temp = 1;
        }
        previous = current;
        count = count > temp ? count : temp;
      }
      return count;
    }
}

//!s.contains(i - 1) will save a lot of work
class Solution {
    public int longestConsecutive(int[] nums) {
      if (nums.length <= 2) {
        return 0;
      }
      Set<Integer> s = new HashSet<>();
      for (int i : nums) {
        s.add(i);
      }
      int count = 1;
      for (int i : nums) {
        if (!s.contains(i - 1)) {
          int current = i;
          int currentCount = 1;
          while (s.contains(current + 1)) {
            currentCount++;
            current = i + 1;
          }
          count = count > currentCount ? count : currentCount;
        }
      }
      return count;
    }
}
