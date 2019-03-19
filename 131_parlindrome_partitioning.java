class Solution {
    List<List<String>> results;
    List<String> bt;

    public List<List<String>> partition(String s) {
      results = new ArrayList<>();
      bt = new ArrayList<>();
      backtrack(s, 0, 0);
      return results;
    }

    private void backtrack(String s, int start, int l) {
  		if (start == s.length()) {
  			ArrayList<String> temp = (ArrayList<String>) bt.clone();
  			results.add(temp);
  			return;
  		}
  		for (int i = l; i <= s.length(); i++) {
  			if (start + i + 1 > s.length()) {
  				return;
  			}
  			if (isPalindrome(s, start, start + i)) {
  				bt.add(s.substring(start, start + i + 1));
  				backtrack(s, start + i + 1, 0);
  				bt.remove(bt.size() - 1);
  			}
  		}
	  }

    private boolean isPalindrome(String str, int l, int r) {
      if (l == r) {
        return true;
      }
      while (l < r) {
          if(str.charAt(l++) != str.charAt(r--)) {
            return false;
          }
      }
      return true;
	  }
}

// Input: "aab"
// Output:
// [
//  ["aa","b"],
//  ["a","a","b"]
// ]
