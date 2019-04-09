class Solution {
   public int[] searchRange(int[] nums, int target) {
      return recursive(nums, target, 0, nums.length - 1);
   }

   private int[] recursive(int[] nums, int target, int start, int end {
       if (start > end) {
           int[] result = {-1, -1};
           return result;
       }
       int mid = start + (end - start) / 2;
       if (nums[mid] < target) {
         return recursive(nums, target, mid + 1, end);
       } else if (nums[mid] > target) {
         return recursive(nums, target, start, mid - 1);
       } else {
           if (nums[start] != target) {
               start = mid;
           }
           while (start - 1 > 0) {
               if (nums[start - 1] == target) {
                   start--;
               } else {
                   break;
               }
           }
           if (nums[end] != target) {
               end = mid;
           }
           while (end + 1 < nums.length) {
               if (nums[end + 1] == target) {
                   end++;
               } else {
                   break;
               }
           }
           int[] result = {start, end};
           return result;
       }
   }
}

// 1 4 4 4 4 4 4 4 4 4 4 4 8
