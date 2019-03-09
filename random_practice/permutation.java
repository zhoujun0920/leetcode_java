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
