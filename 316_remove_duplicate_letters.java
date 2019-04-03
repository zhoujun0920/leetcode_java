// not right
class Solution {
    public String removeDuplicateLetters(String s) {
      int[] result = new int[26];
      for (char c : s.toCharArray()) {
        int index = c - 'a';
        result[index] = 1;
      }
      String r = "";
      for (int i = 0; i < result.length; i++) {
        if (result[i] == 1) {
          char temp = (char)('a' + i);
          r += String.valueOf(temp);
        }
      }
      return r;
    }
}

// not right
// not smallest in lexicographical, but small char is put before bigger char
class Solution {
    public String removeDuplicateLetters(String s) {
      int[] temp = new int[26];
  		for (char c : s.toCharArray()) {
  			int index = c - 'a';
  			temp[index] += 1;
  		}
  		String result = "";
  		char[] sArray = s.toCharArray();
  		int current = 0;
  		for (int i = 0; i < 26; i++) {
  			if (temp[i] == 0) {
  				continue;
  			}
  			char t = (char)('a' + i);
  			for (int j = current; j < sArray.length; j++) {
  				if (sArray[j] == t) {
  					int k = current;
  					while (k < j) {
  						int index = sArray[k] - 'a';
  						if (temp[index] > 0) {
  							if (temp[index] == 1) {
  								result += String.valueOf(sArray[k]);
  								temp[index] = 0;
  							} else if (sArray[k] < t) {
  								result += String.valueOf(sArray[k]);
  								temp[index] = 0;
  							} else {
  								temp[index] -= 1;
  							}
  						}
  						k++;
  					}
  					result += String.valueOf(t);
  					current = j;
  					temp[i] = 0;
  					break;
  				}
  			}
  		}
  		return result;
    }
}


// "cbacdcbc"
class Solution {
  public String removeDuplicateLetters(String s) {
  int[] temp = new int[26];
  for (char c : s.toCharArray()) {
    int index = c - 'a';
    temp[index] += 1;
  }
  String result = "";
  char[] sArray = s.toCharArray();
  int current = 0;
  for (int i = 0; i < sArray.length; i++) {
    int index = sArray[i] - 'a';
    if (temp[index] == 1) {
      for (int k = current; k < i; k++) {
        int tIndex = sArray[k] - 'a';
        temp[tIndex] -= 1;
      }
      for (int j = 0; j < 26; j++) {
        if (temp[j] > 0) {
          for (int k = current; k <= i; k++) {
            char t = sArray[k];
            int tIndex = t - 'a';
            if (temp[tIndex] > 0 && tIndex <= index) {
              result += String.valueOf(t);
              System.out.println(result);
              temp[tIndex] = 0;
            }
          }
        }
      }
      current = i + 1;
    } else if (i == sArray.length - 1) {
      // here is not right
      for (int j = 0; j < 26; j++) {
        if (temp[j] > 0) {
          for (int k = current; k <= i; k++) {
            char t = sArray[k];
            int tIndex = t - 'a';
            if (temp[tIndex] > 0 && tIndex < index) {
              result += String.valueOf(t);
              System.out.println(result);
              temp[tIndex] = 0;
            }
          }
        }
      }
      if (temp[index] > 0) {
        result += String.valueOf(sArray[i]);
      }
    }
  }
  return result;
}
}
