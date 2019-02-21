class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
      int distance = words.length;
      int index1 = -1;
      int index2 = -1;
      for (int i = 0; i < words.length; i++) {
        if (words[i].equals(word1)) {
          index1 = i;
        } else if (words[i].equals(word2)) {
          index2 = i;
        }
        if (index1 >= 0 && index2 >= 0) {
          int temp = index1 > index2 ? index1 - index2 : index2 - index1;
          distance = distance < temp ? distance : temp;
        }
      }
      return distance;
    }
}
