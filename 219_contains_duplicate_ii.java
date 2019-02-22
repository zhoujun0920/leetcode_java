class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
      HashMap<Integer, List<Integer>> position = new HashMap<>();
      for (int i = 0; i < nums.length; i++) {
        List<Integer> temp;
        if (position.containsKey(nums[i])) {
          temp = position.get(nums[i]);
        } else {
          temp = new ArrayList();
        }
        temp.add(i);
        position.put(nums[i], temp);
      }
      for (List<Integer> p : position.values()) {
        for (int i = 0; i < p.size() - 1; i++) {
          if (p.get(i + 1) - p.get(i) <= k) {
            return true;
          }
        }
      }
      return false;
    }
}

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
      Set<Integer> position = new HashSet<>();
      for (int i = 0; i < nums.length; i++) {
        if (position.contains(nums[i])) {
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
