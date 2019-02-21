// Integer.MAX_VALUE
//
class WordDistance {
  HashMap<String, List<Integer>> position;

  public WordDistance(String[] words) {
    position = new HashMap<>();
    if (words != null) {
      for (int i = 0; i < words.length; i++) {
          List<Integer> temp;
          if (position.containsKey(words[i])) {
            temp = position.get(words[i]);
          } else {
            temp = new ArrayList();
          }
          temp.add(i);
          position.put(words[i], temp);
      }
    }
  }

  public int shortest(String word1, String word2) {
      List<Integer> position1 = position.get(word1);
      List<Integer> position2 = position.get(word2);
      int distance = Integer.MAX_VALUE;
      for (Integer i : position1) {
        for (Integer j : position2) {
          int temp = i > j ? i - j : j - i;
          distance = distance < temp ? distance : temp;
        }
      }
      return distance;
  }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */
