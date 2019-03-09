// https://www.geeksforgeeks.org/print-all-possible-combinations-of-r-elements-in-a-given-array-of-size-n/
// combination of n / 2
// if n % 2 == 1, combination n / 2, and put 0, 1, 8 in the middle
// combination is using tree
// isn't right, there are other situations.
class Solution {
  public List<String> findStrobogrammatic(int n) {
		Map<Character, Character> map = new HashMap<>();
		map.put('6', '9');
		map.put('9', '6');
		map.put('1', '1');
		map.put('8', '8');
		map.put('0', '0');

		String str = "01689";
		List<String> allCombination = combination(str, n / 2);
		List<String> allPermutation = new ArrayList<>();
		for (String s : allCombination) {
			allPermutation.addAll(permutation(s));
		}
		int k = allPermutation.size();
		for (int j = 0; j < k; j++) {
			String s = allPermutation.get(j);
			for (int i = s.length() - 1; i >= 0; i--) {
				s += map.get(s.charAt(i));
			}
			allPermutation.set(j, s);
		}
		if (n % 2 == 1) {
			List<String> result = new ArrayList<>();
			int m = allPermutation.size();
			for (int i = 0; i < m; i++) {
				StringBuilder sb1 = new StringBuilder(allPermutation.get(i));
				StringBuilder sb2 = new StringBuilder(allPermutation.get(i));
				StringBuilder sb3 = new StringBuilder(allPermutation.get(i));
				sb1.insert(n / 2, '0');
				sb2.insert(n / 2, '1');
				sb3.insert(n / 2, '8');
				result.add(sb1.toString());
				result.add(sb2.toString());
				result.add(sb3.toString());
			}
			return result;
		}
		return allPermutation;
	}

	private List<String> combination(String str, int r) {
		List<String> results = new ArrayList<>();
		char[] data = new char[r];
		combinationRecursive(results, str, r, 0, data, 0);
		return results;
	}

	private void combinationRecursive(List<String> results, String str, int r, int index, char[] data, int i) {
		int n = str.length();
		if (index == r) {
			results.add(String.valueOf(data));
			return;
		}
		if (i >= n) {
			return;
		}
		data[index] = str.charAt(i);
		combinationRecursive(results, str, r, index + 1, data, i + 1);
		combinationRecursive(results, str, r, index, data, i + 1);
	}

	private List<String> permutation(String str) {
		List<String> results = new ArrayList<>();
		permutationRecursive(results, "", str);
		return results;
	}

	private void permutationRecursive(List<String> results, String prefix, String str) {
		int n = str.length();
		if (n == 1) {
			if (prefix.charAt(0) != '0') {
				results.add(prefix + str);
			}
			return;
		}
		for (int i = 0; i < n; i++) {
			permutationRecursive(results,prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1));
		}
	}
}

// Still slow
class Solution {
    public List<String> findStrobogrammatic(int n) {
      Map<Character, Character> hm = new HashMap<>();
      hm.put('6', '9');
      hm.put('9', '6');
      hm.put('1', '1');
      hm.put('8', '8');
      hm.put('0', '0');
      String str = "01689";
      List<String> results = new ArrayList<>();
      char[] data = new char[n / 2];
      stroboRecursive(results, str, n, hm, data, 0);
      return results;
    }

    private void stroboRecursive(List<String> results, String str, int n, Map<Character, Character> hm, char[] data, int index) {
      int tempN = n / 2;
      if (index == tempN) {
        String s = String.valueOf(data);
        if (n % 2 == 1) {
            String s1 = s + "0";
            String s2 = s + "1";
            String s3 = s + "8";
            for (int j = tempN - 1; j >=0; j--) {
              char t = hm.get(data[j]);
              s1 += t;
              s2 += t;
              s3 += t;
            }
            results.add(s1);
            results.add(s2);
            results.add(s3);
        } else {
            for (int j = tempN - 1; j >=0; j--) {
              s += hm.get(data[j]);
            }
            results.add(s);
        }
        return;
      }
      for (int i = 0; i < str.length(); i++) {
        if (index == 0 && str.charAt(i) == '0') {
          continue;
        }
        data[index] = str.charAt(i);
        stroboRecursive(results, str, n, data, index + 1);
      }
    }
}

class Solution {
    public List<String> findStrobogrammatic(int n) {

    }
}
