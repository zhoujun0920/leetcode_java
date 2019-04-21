class Solution {
    public int missingNumber(int[] nums) {
        int sum = (1 + nums.length) * nums.length / 2;
        for (int i = 0; i < nums.length; i++) {
            sum -= nums[i];
        }
        return sum;
    }
}

class Solution {
    public int missingNumber(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }
}


// xor 1 ^ 0 = 1, 0 ^ 1 = 0, 1 ^ 1 = 0, 0 ^ 0 = 0
// a ^ a = 0

//Input: [3,0,1]
//Output: 2
