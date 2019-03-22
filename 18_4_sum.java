class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
      Arrays.sort(nums);
      List<List<Integer>> results = new ArrayList<>();
      for (int i = 0; i < nums.length; i++) {
        if (i == 0 || nums[i - 1] != nums[i]) {
          for (int j = i + 1; j < nums.length; j++) {
            if (j == i + 1 || nums[j - 1] != nums[j]) {
              int temp = target - nums[i] - nums[j];
              int low = j + 1;
              int high = nums.length - 1;
              while (low < high) {
                if (temp == nums[low] + nums[high]) {
                  results.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                  low++;
                  high--;
                  while (low < high && nums[low - 1] == nums[low]) {
                    low++;
                  }
                  while (low < high && nums[high + 1] == nums[high]) {
                    high--;
                  }
                } else if (temp < nums[low] + nums[high]) {
                  high--;
                } else {
                  low++;
                }
              }
            }
          }
        }
      }
      return results;
    }
}

// Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

// A solution set is:
// [
  // [-1,  0, 0, 1],
//   [-2, -1, 1, 2],
//   [-2,  0, 0, 2]
// ]

// -2 -1 0 0 1 2
