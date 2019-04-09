class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    count++;
                }
            }
            results.add(count);
        }
        return results;
    }
}

class Solution {
    public List<Integer> countSmaller(int[] nums) {

    }

    
}
