class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>();
        dict.addAll(wordList);
        if (!dict.contains(endWord)) {
            return new LinkedList<>();
        }
        Queue<String> queue = new ArrayDeque<>();
        queue.add(beginWord);
        List<List<String>> results = new LinkedList<>();
        List<String> temp = new LinkedList<>();
        int count = 0;
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                String word = queue.poll();
                temp.add(word);
                if (count == 0 || temp.size() < count) {
                    char[] wordArray = word.toCharArray();
                    for (int j = 0; j < wordArray.length; j++) {
                        char ch = wordArray[j];
                        for (char k = 'a'; k <= 'z'; k++) {
                            if (k == ch) {
                                continue;
                            }
                            wordArray[j] = k;
                            String tempWord = String.valueOf(wordArray);
                            if (endWord.equals(tempWord)) {
                                temp.add(endWord);
                                results.add(new LinkedList<>(temp));
                                count = temp.size();
                                temp.remove(temp.size() - 1);
                                return results;

                            }
                            if (!dict.contains(tempWord)) {
                                wordArray[j] = ch;
                                continue;
                            }
                            dict.remove(tempWord);
                            queue.add(tempWord);
                            wordArray[j] = ch;
                        }
                    }
                }
                //temp.remove(temp.size() - 1);
            }
            //temp.remove(temp.size() - 1);
        }
        return results;
    }
}
