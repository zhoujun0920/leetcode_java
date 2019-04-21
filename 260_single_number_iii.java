class Solution {
    public int[] singleNumber(int[] nums) {
       int seperator = 0;
       for (int num : nums) {
         seperator ^= num;
       }
       int a = 0;
       int b = 0;
       int temp = 1;
       while ((seperator & temp) == 0) {
         temp *= 2;
       }
       for (int num : nums) {
         if ((num & temp) == 0) {
           a ^= num;
         } else {
           b ^= num;
         }
       }
       int[] result = {a, b};
       return result;
    }
}

// 1,2,1,3,2,5
// 3 ^ 5 must has some bit is 1, which can be grouped into two set
//
