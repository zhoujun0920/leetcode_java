class Solution {
    public String reverseWords(String s) {
      String[] sArray = s.split(" ");
      int i = 0;
      int j = sArray.length - 1;
      while (i < j) {
        String temp = sArray[i];
        sArray[i] = sArray[j];
        sArray[j] = temp;
        i++;
        j--;
      }
      String result = "";
      for (int k = 0; k < sArray.length; k++) {
        if (!sArray[k].equals("")) {
          result += sArray[k];
          if (k != sArray.length - 1) {
            result += " ";
          }
        }
      }
      return result;
    }
}
