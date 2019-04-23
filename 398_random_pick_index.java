class Solution {

    int[] original;
    Random rand = new Random();

    public Solution(int[] nums) {
      Arrays.sort(nums);
      original = nums;
    }

    public int pick(int target) {
      int position = recursive(0, original.length - 1, target);
      int start = position;
      int end = position;
      while (start >= 0 && original[start] == target) {
        if (start == 0) {
          break;
        }
        start--;
      }
      while (end <= original.length - 1 && original[end] == target) {
        if (end == original.length - 1) {
          break;
        }
        end++;
      }
      int r = rand.nextInt(end - start) + start;
      return original[r];
    }

    private int recursive(int start, int end, int target) {
      int mid = start + (end - start) / 2;
      if (original[mid] == target) {
        return target;
      }
      if (original[mid] > target) {
        return recursive(start, mid - 1, target);
      }
      return recursive(mid + 1, end, target);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */


 class Solution {

     Map<Integer, List<Integer>> hm;

     public Solution(int[] nums) {
       hm = new HashMap<>();
       for (int i = 0; i < nums.length; i++) {
          List<Integer> s = hm.getOrDefault(nums[i], new LinkedList<>());
          s.add(i);
          hm.put(nums[i], s);
       }
     }

     public int pick(int target) {
       List<Integer> s = hm.getOrDefault(target, new LinkedList<>());
       int r = rand.nextInt(s.size());
       return s.get(r);
     }
 }
