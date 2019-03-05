class Solution {
    public String reverseVowels(String s) {
      char[] sArray = s.toCharArray();
      HashMap<Character, Integer> hm = new HashMap<>();
      hm.put('a', 1);
      hm.put('e', 1);
      hm.put('i', 1);
      hm.put('o', 1);
      hm.put('u', 1);
      hm.put('A', 1);
      hm.put('E', 1);
      hm.put('I', 1);
      hm.put('O', 1);
      hm.put('U', 1);
      int i = 0;
      int j = sArray.length;
      while (i < j) {
        while (!hm.contansKey(sArray[i])) {
          i++;
        }
        while (!hm.contansKey(sArray[j])) {
          j--;
        }
        char temp = sArray[i];
        sArray[i] = sArray[j];
        sArray[j] = temp;
      }
      return String.valueOf(sArray);
    }
}

class Solution {
    public String reverseVowels(String s) {
      
    }
}
