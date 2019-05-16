class NumArray {

    int[] temp;

    public NumArray(int[] nums) {
      temp = nums;
    }

    public int sumRange(int i, int j) {
      int sum = 0;
      for (int n = i; n <= j; n++) {
        sum += temp[i];
      }
      return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */


 class NumArray {

   int[] temp;

     public NumArray(int[] nums) {
       temp = new int[nums.length];
       for (int i = 0; i < nums.length; i++) {
         if (i == 0) {
             temp[i] = nums[i];
         } else {
             temp[i] = temp[i - 1] + nums[i];
         }
       }
     }

     public int sumRange(int i, int j) {
       if (i == 0) {
         return temp[j];
       }
       return temp[j] - temp[i - 1];
     }
 }


// [-2, 0, 3, -5, 2, -1]
