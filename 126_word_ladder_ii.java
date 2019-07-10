class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new LinkedList<>();
        Set<String> set = new HashSet<>();
        for (String s : wordList) {
            set.add(s);
        }
        if (!set.contains(endWord)) {
            return result;
        }
        if (beginWord.equals(endWord)) {
            List<String> t = new LinkedList<>();
            t.add(beginWord);
            result.add(t);
            return result;
        }
        Queue<String> queue = new LinkedList<>();
        Queue<List<String>> ladderQueue = new LinkedList<>();
        Queue<Set<String>> setQueue = new LinkedList<>();
        queue.add(beginWord);
        List<String> ttt = new LinkedList<>();
        ttt.add(beginWord);
        ladderQueue.add(ttt);
        setQueue.add(set);
        boolean found = false;
        while (!queue.isEmpty() && !found) {
            Queue<String> current = new LinkedList<>();
            while (!queue.isEmpty()) {
                String currentWord = queue.poll();
                List<String> tempList = ladderQueue.poll();
                Set<String> tempSet = setQueue.poll();
                char[] array = currentWord.toCharArray();
                for (int i = 0; i < currentWord.length(); i++) {
                    char originalChar = array[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        array[i] = j;
                        String temp = String.valueOf(array);
                        if (temp.equals(endWord)) {
                            found = true;
                            List<String> newTemp = new LinkedList<>(tempList);
                            newTemp.add(temp);
                            result.add(newTemp);
                        }
                        if (!found && tempSet.contains(temp)) {
                            current.add(temp);
                            List<String> newTemp = new LinkedList<>(tempList);
                            Set<String> newTempSet = new HashSet<>(tempSet);
                            newTempSet.remove(temp);
                            newTemp.add(temp);
                            ladderQueue.add(newTemp);
                            setQueue.add(newTempSet);
                        }
                    }
                    array[i] = originalChar;
                }
            }
            if (!found) {
                queue.addAll(current);
            }
        }
        return result;
    }
}
