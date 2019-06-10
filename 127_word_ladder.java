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
        Set<String> set = new HashSet<>();
        for (String word : wordList) {
            set.add(word);
        }
        if (!set.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int count = 1;
        while (!queue.isEmpty()) {
            Queue<String> currentQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                String word = queue.poll();
                char[] wordArray = word.toCharArray();
                for (int i = 0; i < wordArray.length; i++) {
                    char temp = wordArray[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        if (temp == j) {
                            continue;
                        }
                        wordArray[i] = j;
                        String newWord = String.valueOf(wordArray);
                        if (newWord.equals(endWord)) {
                            return ++count;
                        }
                        if (set.contains(newWord)) {
                            currentQueue.add(newWord);
                            set.remove(newWord);
                        }
                    }
                    wordArray[i] = temp;
                }
            }
            count++;
            queue.addAll(currentQueue);
        }
        return 0;
    }
}
