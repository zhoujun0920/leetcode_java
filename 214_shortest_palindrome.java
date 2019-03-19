class Solution {
  public String shortestPalindrome(String s) {
      int j = s.length();
      if (j == 0) {
          return "";
      }
      boolean isOdd = false;
      for (int i = s.length() - 1; i >= 0; i--) {
          if (isP(s, i, i)) {
              j = i;
              break;
          }
          if (isP(s, i - 1, i)) {
              j = i;
              isOdd = true;
              break;
          }
      }
      if (isOdd) {
          return reverse(s.substring(j + j)) + s;
      }
      return reverse(s.substring(j + j + 1)) + s;
  }

  private boolean isP(String s, int start, int end) {
      if (end >= s.length()) {
          return false;
      }
      if (start == 0) {
          if (s.charAt(start) == s.charAt(end)) {
              return true;
          }
          return false;
      }
      if (start > 0 && end <= s.length() - 1) {
          if (s.charAt(start) == s.charAt(end)) {
              return isP(s, start - 1, end + 1);
          }
      }
      return false;
  }

  private String reverse(String s) {
      int i = 0;
      int j = s.length() - 1;
      char[] sArray = s.toCharArray();
      while (i < j) {
          char temp = sArray[i];
          sArray[i] = sArray[j];
          sArray[j] = temp;
          i++;
          j--;
      }
      return String.valueOf(sArray);
  }
}


class Solution {
  public String shortestPalindrome(String s) {
		int j = s.length();
		if (j == 0) {
			return "";
		}
		for (int i = s.length() - 1; i >= 0; i--) {
			if (isP(s, i, i)) {
				return reverse(s.substring(i + i + 1)) + s;
			}
			if (isP(s, i - 1, i)) {
				return reverse(s.substring(i + i)) + s;
			}
		}
		return "";
	}

	private boolean isP(String s, int start, int end) {
		int count = (s.length() - end) > start ? (start + 1) : (s.length() - end);
		for (int i = 0; i < count; i++) {
			if (s.charAt(start) == s.charAt(end)) {
				if (start == 0) {
					return true;
				}
				start--;
				end++;
			} else {
				return false;
			}
		}
		return false;
	}

	private String reverse(String s) {
		int i = 0;
		int j = s.length() - 1;
		char[] sArray = s.toCharArray();
		while (i < j) {
			char temp = sArray[i];
			sArray[i] = sArray[j];
			sArray[j] = temp;
			i++;
			j--;
		}
		return String.valueOf(sArray);
	}
}
