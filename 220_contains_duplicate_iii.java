//Long is 64 bit sign
//Integer is 32 bit sign

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Set<Integer> position = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
          for (Integer j : position) {
            if (j <= Long.valueOf(t) + Long.valueOf(nums[i]) && j >= Long.valueOf(nums[i])  - Long.valueOf(t)) {
              return true;
            }
          }
          position.add(nums[i]);
          if (position.size() > k) {
            position.remove(nums[i - k]);
          }
        }
        return false;
    }
}

//TreeSet is self balance tree
// ceiling(n), find the least number larger then n
// floor(n), find the largest number smaller then n
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> position = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
          Integer c = position.ceiling(nums[i]);
          if (c != null && c <= Long.valueOf(nums[i]) + Long.valueOf(t)) {
            return true;
          }
          Integer f = position.floor(nums[i]);
          if (f != null && f >= Long.valueOf(nums[i]) - Long.valueOf(t)) {
            return true;
          }
          position.add(nums[i]);
          if (position.size() > k) {
            position.remove(nums[i - k]);
          }
        }
        return false;
    }
}

//Bucket sort
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        
    }

    private void insertSort(int[]] nums) {
        for(int i = 1; i < nums.length; i++) {
          if (nums[i] < nums[i - 1]) {
            int j = i;
            while (nums[j] < nums[j - 1]) {
              int temp = nums[j];
              nums[j] = nums[j - 1];
              nums[j - 1] = temp;
              j--;
            }
          }
        }
    }
}
