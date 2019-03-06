class Solution {
    public List<String> generatePossibleNextMoves(String s) {
      List<String> result = new ArrayList<>();
      char[] sArray = s.toCharArray();
      for (int i = 0; i < sArray.length - 1; i++) {
        if (sArray[i] != '+') {
          continue;
        }
        if (sArray[i + 1] != '+') {
          continue;
        }
        sArray[i] = '-';
        sArray[i + 1] = '-';
        result.add(String.valueOf(sArray));
        sArray[i] = '+';
        sArray[i + 1] = '+';
      }
      return result;
    }
}
