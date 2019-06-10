class Solution {

    int index = 0;
    int[] result;
    Set<Integer> visited;
    Map<Integer, Set<Integer>> map;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        map = new HashMap<>();
        visited = new HashSet<>();
        result = new int[numCourses];
        for (int[] pre : prerequisites) {
          Set<Integer> set = map.getOrDefault(pre[0], new HashSet<>());
          set.add(pre[1]);
          map.put(pre[0], set);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!recursive(i, new HashSet<>())) {
              return new int[0];
            }
        }
        return result;
    }

    private boolean recursive(int start, Set<Integer> temp) {
        if (map.containsKey(start)) {
          if (visited.contains(start)) {
            return true;
          }
          if (temp.contains(start)) {
            return false;
          }
          temp.add(start);
          for (int i : map.get(start)) {
            if (!recursive(i, temp)) {
              return false;
            }
          }
        }
        if (!visited.contains(start)) {
            visited.add(start);
            result[index++] = start;
        }
        return true;
    }
}
