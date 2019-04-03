// string.substring(begin, end);
// Include and exclude every element
class Solution {
  private void permutation(String str) {
		List<String> results = new ArrayList<>();
		permutationRecursive(results, "", str);
		return;
	}

	private void permutationRecursive(List<String> results, String prefix, String str) {
		int n = str.length();
		if (n == 1) {
			results.add(prefix + str);
			return;
		}
		for (int i = 0; i < n; i++) {
			permutationRecursive(results, prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1));
		}
	}
}

// Heap's Permutation
class Solution {
  List<List<Integer>> results;

	public List<List<Integer>> permute(int[] nums) {
		results = new ArrayList<>();
		recursive(nums, nums.length);
		return results;
	}

	private void recursive(int[] nums, int k) {
		if (k == 1) {
			List<Integer> intList = new LinkedList<>();
			for (int i : nums) {
				intList.add(i);
			}
			results.add(new LinkedList<>(intList));
			return;
		}
		recursive(nums, k - 1);
		for (int i = 0; i < k - 1; i++) {
			if (k % 2 == 0) {
				swap(nums, i, k - 1);
			} else {
				swap(nums, 0, k - 1);
			}
			recursive(nums, k - 1);
		}
	}

	private void swap(int[] nums, int i, int j) {
		Integer temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
