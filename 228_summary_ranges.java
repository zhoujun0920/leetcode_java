class Solution {
    public List<String> summaryRanges(int[] nums) {
      List<String> list = new ArrayList<>();
      int n = nums.length;
      if (n == 0) {
        return list;
      }
      int start = 0;
      for (int i = 0; i < n - 1; i++) {
        if (nums[i] == nums[i + 1] - 1) {
          continue;
        } else {
          if (start == i) {
            list.add(String.valueOf(nums[start]));
          } else {
            list.add(String.valueOf(nums[start]) + "->" + String.valueOf(nums[i]));
          }
          start = i + 1;
        }
      }
      if (start == n - 1) {
        list.add(String.valueOf(nums[start]));
      } else {
        list.add(String.valueOf(nums[start]) + "->" + String.valueOf(nums[n - 1]));
      }
      return list;
    }
}

class Solution {
    public List<String> summaryRanges(int[] nums) {
      
    }
}
