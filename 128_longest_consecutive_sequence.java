// Super slow
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        quickSort(nums, 0, nums.length - 1);
        int count = 1;
        int temp = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                continue;
            }
            if (nums[i - 1] == nums[i] - 1) {
                temp++;
            } else {
                temp = 1;
            }
            count = count > temp ? count : temp;
        }
        return count;
    }

    public void quickSort(int[] nums, int start, int end) {
        if (start < end) {
            int temp = partition(nums, start, end);
            quickSort(nums, start, temp - 1);
            quickSort(nums, temp + 1, end);
        }
    }

    public int partition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int i = start;
        for (int j = start; j < end; j++) {
            if (nums[j] < pivot) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
        int temp = nums[i];
        nums[i] = pivot;
        nums[end] = temp;
        return i;
    }
}
