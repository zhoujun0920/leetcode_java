class Solution {
  public int threeSumSmaller(int[] nums, int target) {
      Arrays.sort(nums);
  		int m = 0;
  		for (int i = 0; i < nums.length - 2; i++) {
  				int temp = target - nums[i];
  				int low = i + 1;
  				int high = nums.length - 1;
  				while (low < high) {
  					while (low < high) {
  						if (temp > nums[low] + nums[high]){
  							m++;
  						}
  						high--;

  					}
  					low++;
            high = nums.length - 1;
  				}
  		}
  		return m;
  }
}

class Solution {
  public int threeSumSmaller(int[] nums, int target) {
      
  }
}


// Input: nums = [-2,0,1,3], and target = 2
// Output: 2
// Explanation: Because there are two triplets which sums are less than 2:
//             [-2,0,1]
//             [-2,0,3]
