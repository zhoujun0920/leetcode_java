// DFS is going to  TLE
class Solution {

  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    int h = recursive(beginWord, endWord, wordList);
    if (h == Integer.MAX_VALUE) {
      return 0;
    }
    return h;
  }

  private int recursive(String beginWord, String endWord, List<String> wordList) {
    if (beginWord.equals(endWord)) {
      return 1;
    }
    int h = Integer.MAX_VALUE;
    for (int i = 0; i < wordList.size(); i++) {
      String temp = wordList.get(i);
      if (wordDiff(beginWord, temp)) {
          List<String> tempList = new ArrayList<>(wordList);
          tempList.remove(i);
        int h1 = recursive(temp, endWord, tempList);
        h = h < h1 ? h : h1;
      }
    }
  if (h == Integer.MAX_VALUE) {
      return h;
  }
    return h + 1;
  }

  private boolean wordDiff(String word1, String word2) {
    int count = 0;
    for (int i = 0; i < word1.length(); i++) {
      if (word1.charAt(i) != word2.charAt(i)) {
        count++;
        if (count > 1) {
          return false;
        }
      }
    }
    return true;
  }
}


// BFS
// Queue interface
// offer, poll, peek
// add, remove, element
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
      Set<String> dict = new HashSet<>();
      dict.addAll(wordList);
      if (!dict.contains(endWord)) {
        return 0;
      }
      Queue<String> queue = new LinkedList<>();
      queue.offer(beginWord);
      int count = 0;
      while (!queue.isEmpty()) {
        count++;
        for (int i = queue.size(); i > 0; i--) {
          String word = queue.poll();
          char[] wordArray = word.toCharArray();
          for (int j = 0; j < wordArray.length; j++) {
            char ch = wordArray[j];
            for (char k = 'a'; k <= 'z'; k++) {
              if (ch == k) {
                continue;
              }
              wordArray[j] = k;
              String newWord = String.valueOf(wordArray);
              if (newWord.equals(endWord)) {
                return count + 1;
              }
              wordArray[j] = ch;
              if (!dict.contains(newWord)) {
                continue;
              }
              dict.remove(newWord);
              queue.offer(newWord);
            }
          }
        }
      }
      return 0;
    }
}
