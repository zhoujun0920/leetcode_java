class Solution {
    public int[] twoSum(int[] nums, int target) {
      Map<Integer, List<Integer>> hm = new HashMap<>();
      int[] result = new int[2];
      for (int i = 0; i < nums.length; i++) {
        if (hm.containsKey(nums[i])) {
          List<Integer> temp = hm.get(nums[i]);
          temp.add(i);
          hm.put(nums[i], temp);
        } else {
          List<Integer> temp = new ArrayList<>();
          temp.add(i);
          hm.put(nums[i], temp);
        }
      }
      for (int i : nums) {
        int j = target - i;
        if (hm.containsKey(j)) {
          if (i == j) {
            if (hm.get(i).size() > 1) {
              result[0] = hm.get(i).get(0);
              result[1] = hm.get(i).get(1);
            }

          } else {
            result[0] = hm.get(i).get(0);
            result[1] = hm.get(j).get(0);
          }
        }
      }
      return result;
    }
}

// one pass hashmap
class Solution {
    public int[] twoSum(int[] nums, int target) {
      Map<Integer, Integer> hm = new HashMap<>();
      int[] result = new int[2];
      for (int i = 0; i < nums.length; i++) {
        int j = target - nums[i];
        if (hm.containsKey(j)) {
          result[0] = hm.get(j);
          result[1] = i;
          break;
        } else {
          hm.put(nums[i], i);
        }
      }
      return result;
    }
}
