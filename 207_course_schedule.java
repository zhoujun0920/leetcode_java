class Solution {

  Set<Integer> parent;

  public boolean canFinish(int numCourses, int[][] prerequisites) {
      int m = prerequisites.length;
      if (m == 0) {
        return true;
      }
      parent = new HashSet<>();
      boolean found = true;
      for (int i = 0; i < m; i++) {
          parent.add(prerequisites[i][1]);
          found = recursive(numCourses - 1, prerequisites, prerequisites[i][0]);
          if (!found) {
              break;
          }
      }
       return found;
  }

  private boolean recursive(int numCourses, int[][] prerequisites, int i) {
      if (numCourses == 0) {
        return true;
      }
      for (int j = 0; j < prerequisites.length; j++) {
        if (prerequisites[j][1] == i) {
            if (parent.contains(prerequisites[j][0])) {
                return false;
            } else {
                parent.add(prerequisites[j][1]);
                  return recursive(numCourses - 1, prerequisites, prerequisites[j][0]);
            }
        }
      }
      return true;
  }
}

class Solution {

    Map<Integer, Set<Integer>> parent;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int m = prerequisites.length;
        if (m == 0) {
          return true;
        }
        parent = new HashMap<>();
        for (int i = 0; i < m; i++) {
            Set<Integer> l1 = parent.getOrDefault(prerequisites[i][0], new HashSet<>());
            l1.add(prerequisites[i][1]);
            parent.put(prerequisites[i][0], l1);
            Set<Integer> l2 = parent.getOrDefault(prerequisites[i][1], new HashSet<>());
            if (l2.size() > 0 && recursive(l2, prerequisites[i][0])) {
              return false;
            }
            parent.put(prerequisites[i][1], l2);
        }
        return true;
    }

    private boolean recursive(Set<Integer> l, int temp) {
      if (l.contains(temp)) {
        return true;
      }
      for (Integer i : l) {
         if (recursive(parent.getOrDefault(i, new HashSet<>()), temp)) {
           return true;
         }
      }
      return false;
    }
}

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] pre : prerequisites) {
            Set<Integer> set = map.getOrDefault(pre[0], new HashSet<>());
            set.add(pre[1]);
            map.put(pre[0], set);
        }
        boolean[] memo = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(map, i, memo, new boolean[numCourses])) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(Map<Integer, Set<Integer>> map, int i, boolean[] memo, boolean[] current) {
        if (memo[i]) {
            return memo[i];
        }
        if (current[i]) {
            return false;
        }
        current[i] = true;
        if (map.containsKey(i)) {
            for (int j : map.get(i)) {
                if (!dfs(map, j, memo, current)) {
                    return false;
                }
            }
        }
        return memo[i] = true;
    }
}
