// Input:
// [
//   "wrt",
//   "wrf",
//   "er",
//   "ett",
//   "rftt"
// ]
//
// Output: "wertf"


// Topological sort
class Solution {
    public String alienOrder(String[] words) {
      Map<Character, Set<Character>> map = new HashMap<>();
      int[] indegree = new int[26];
      buildGraph(map, words, indegree);
      return bfs(map, indegree);
    }

    private void buildGraph(Map<Character, Set<Character>> map, String[] words, int[] indegree) {
      for (String word : words) {
        for (int i = 0; i < word.length(); i++) {
          map.putIfAbsent(word.charAt(i), new HashSet<>());
        }
      }
      for (int i = 1; i < words.length; i++) {
        String str1 = words[i - 1];
        String str2 = words[i];
        for (int j = 0; j < Math.min(str1.length(), str2.length()); j++) {
          if (str1.charAt(j) != str2.charAt(j)) {
            Set<Character> neighbor = map.get(str1.charAt(j));
            if (!neighbor.contains(str2.charAt(j))) {
              neighbor.add(str2.charAt(j));
              map.put(str1.charAt(j), neighbor);
              indegree[str2.charAt(j) - 'a']++;
            }
            break;
          }
        }
      }
    }

    private String bfs(Map<Character, Set<Character>> map, int[] indegree) {
      Queue<Character> queue = new LinkedList<>();
      StringBuilder sb = new StringBuilder();
      for (char c : map.keySet()) {
        if (indegree[c - 'a'] == 0) {

          queue.add(c);
        }
      }
      while (!queue.isEmpty()) {
        char current = queue.poll();
        sb.append(current);
        for (char temp : map.get(current)) {
          indegree[temp - 'a']--;
          if (indegree[temp - 'a'] == 0) {
            queue.add(temp);
          }
        }
      }
      return sb.length() == map.size() ? sb.toString() : "";
    }
}
