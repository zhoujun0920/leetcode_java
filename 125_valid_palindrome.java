// character, number, ignore case.
class Solution {
    public boolean isPalindrome(String s) {
      char[] sArray = s.toCharArray();
  		int i = 0;
  		int j = sArray.length - 1;
  		while (i < j) {
  			while (i < j && (sArray[i] < 'a' || sArray[i] > 'z') && (sArray[i] < 'A' || sArray[i] > 'Z') && (sArray[i] < '0' || sArray[i] > '9')) {
  				i++;
  			}
  			while (i < j && (sArray[j] < 'a' || sArray[j] > 'z') && (sArray[j] < 'A' || sArray[j] > 'Z') && (sArray[j] < '0' || sArray[j] > '9')) {
  				j--;
  			}
  			if (Character.toLowerCase(sArray[i]) != Character.toLowerCase(sArray[j])) {
  				return false;
  			}
  			i++;
  			j--;
  		}
  		return true;
    }
}

// Input: "A man, a plan, a canal: Panama"
// Output: true

// Input: "race a car"
// Output: false
