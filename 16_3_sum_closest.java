class Solution {
  int diff = Integer.MAX_VALUE;
  int s = 0;

  public int threeSumClosest(int[] nums, int target) {
    recursive(nums, 0, 0, 0, target);
    return s;
  }

  private void recursive(int[] nums, int index, int sum, int i, int target) {
    if (index == 3) {
      if (sum > target) {
        if (diff > sum - target) {
          diff = sum - target;
          s = sum;
        }
      } else {
        if (diff > target - sum) {
          diff = target - sum;
          s = sum;
        }
      }
      return;
    }
    if (i >= nums.length) {
      return;
    }
    recursive(nums, index + 1, sum + nums[i], i + 1, target);
    recursive(nums, index, sum, i + 1, target);
  }
}


class Solution {
  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
		int s = 0;
		int diff = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (i == 0 || nums[i] != nums[i - 1]) {
				int temp = target - nums[i];
				int low = i + 1;
				int high = nums.length - 1;
				while (low < high) {
					if (temp > nums[low] + nums[high]) {
						if (diff > temp - (nums[low] + nums[high])){
							diff = temp - (nums[low] + nums[high]);
							s = nums[i] + nums[low] + nums[high];
						}
						low++;
						while (low < high && nums[low - 1] == nums[low]) {
							low++;
						}
					} else if (temp < nums[low] + nums[high]) {
						if (diff > nums[low] + nums[high] - temp) {
							diff = nums[low] + nums[high] - temp;
							s = nums[i] + nums[low] + nums[high];
						}
						high--;
						while (low < high && nums[high + 1] == nums[high]) {
							high--;
						}
					} else {
						return target;
					}
				}
			}
		}
		return s;
  }

}
