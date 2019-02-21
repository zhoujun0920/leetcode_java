class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
      HashMap<String, List<Integer>> position = new HashMap<>();
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
        int distance = Integer.MAX_VALUE;
        if (word1.equals(word2)) {
            List<Integer> position1 = position.get(word1);
            for (int i = 0; i < position1.size(); i++) {
                 for (int j = i + 1; j < position1.size(); j++) {
                    int temp = position1.get(i) > position1.get(j) ? position1.get(i) - position1.get(j) : position1.get(j) - position1.get(i);
                    distance = distance < temp ? distance : temp;
                }
            }
        } else {
            List<Integer> position1 = position.get(word1);
            List<Integer> position2 = position.get(word2);
            for (Integer i : position1) {
                 for (Integer j : position2) {
                    int temp = i > j ? i - j : j - i;
                    distance = distance < temp ? distance : temp;
                }
            }
        }
        return distance;
    }
}


class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
      int distance = words.length;
      int index1 = -1;
      int index2 = -1;
      if (word1.equals(word2)) {
        boolean update1 = false;
        boolean update2 = false;
        for (int i = 0; i < words.length; i++) {
          if (!update1 && words[i].equals(word1)) {
            index1 = i;
            update1 = true;
          } else if (!update2 && words[i].equals(word2)) {
            index2 = i;
            update2 = true;
          }
          if (index1 >= 0 && index2 >= 0) {
            int temp = 0;
            if (index1 > index2) {
              temp = index1 - index2;
              update2 = false;
            } else {
              temp = index2 - index1;
              update1 = false;
            }
            distance = distance < temp ? distance : temp;
          }
        }
      } else {
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
      }
      return distance;
    }
    }
}
