class Solution {

    int[] original;
    int[] shuff;
    Random rand = new Random();

    public Solution(int[] nums) {
      original = nums;
      shuff = nums.clone(); // remember to deep copy
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
      shuff = original;
      original = original.clone(); // remember to deep copy
      return shuff;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
      for (int i = 0; i < shuff.length; i++) {
        swapAt(i, randRange(i, shuff.length));
      }
      return shuff;
    }

    private int randRange(int min, int max) {
      return rand.nextInt(max - min) + min;
    }

    private void swapAt(int i, int j) {
      int temp = shuff[i];
      shuff[i] = shuff[j];
      shuff[j] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
