class Solution {
    public int lengthOfLongestSubstring(String s) {
      if (s.length() < 2) {
  			return s.length();
  		}
  		Map<Character, Integer> hm = new HashMap<>();
  		int i = 0;
  		int j = 0;
  		int m = Integer.MIN_VALUE;
  		char[] sArray = s.toCharArray();
  		while (j < s.length()) {
  			char temp = sArray[j];
  			if (hm.containsKey(temp)) {
  				int d = hm.get(temp);
  				while (i < d) {
  					char k = sArray[i++];
  					hm.remove(k);
  				}
          hm.put(temp, j);
  				i++;
  			} else {
  				hm.put(temp, j);
  				if (j - i + 1 > m) {
  					m = j - i + 1;
  				}
  			}
  			j++;
  		}
  		return m;
    }
}

// "tmmzuxt"
// 5

// "abcabcbb"
// 3

// "bbbbb"
// 1

// "pwwkew"
// 3
