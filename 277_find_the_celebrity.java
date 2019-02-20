/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

// Find the one who knows nobody. Then make sure others know him
// Time O(n^2), Memory O(n)
class Solution extends Relation {
  public int findCelebrity(int n) {
      HashMap<Integer, Integer> checked = new HashMap<>();
      for (Integer i = 0; i < n; i++) {
        if (!checked.containsKey(i)) {
          for (Integer j = 0; j < n; j++) {
            if (i == j) {
              continue;
            } else {
              if (knows(i, j)) {
                checked.put(i, 1);
                if (knows(j, i)) {
                  checked.put(j, 1);
                }
                break;
              }
              if (knows(j, i)) {
                checked.put(j, 1);
              }
            }
          }
        }
      }
      if (checked.keySet().size() == n) {
        return -1;
      } else {
        for (Integer i = 0; i < n; i++) {
          if (!checked.containsKey(i)) {
            boolean isFound = false;
            for (Integer j = 0; j < n; j++) {
              if (!knows(j, i)) {
                isFound = true;
                break;
              }
            }
            if (!isFound) {
              return i;
            }
          }
        }
      }
      return -1;
  }
}

// Using stack
class Solution extends Relation {
  public int findCelebrity(int n) {
    Stack<Integer> stack = new Stack<>();
    for (Integer i = 0; i < n; i++) {
      stack.push(i);
    }
    while (stack.size() > 1) {
      Integer i = stack.pop();
      Integer j = stack.pop();
      if (knows(i, j)) {
        if (knows(j, i)) {
          continue;
        }
        stack.push(j);
      } else if (knows(j, i)) {
        stack.push(i);
      }
    }
    if (stack.size() == 0) {
      return -1;
    }
    Integer result = stack.pop();
    for (Integer i = 0; i < n; i++) {
      if (i != result) {
        if (!knows(i, result) || knows(result, i)) {
          return -1;
        }
      }
    }
    return result;
  }
}

// two pointer
// if a knows b, a can't be celebrity.
// if a doesn't know b, b can't be celebrity
class Solution extends Relation {
  public int findCelebrity(int n) {
    int i = 0;
    int j = n - 1;
    while (i < j) {
      int temp = i;
      if (knows(temp, j)) {
        i++;
      } else {
        j--;
      }
    }
    for (int k = 0; k < n; k++) {
      if (j != k) {
        if (!knows(k, j) || knows(j, k)) {
          return -1;
        }
      }
    }
    return j;
  }
}


[
  [1,0],
  [0,1],
]

[
  [1,1,0],
  [0,1,0],
  [1,1,1]
]

[
  [1,1,0],
  [1,1,1],
  [1,1,1]
]

[
  [1,0,1],
  [1,1,0],
  [0,1,1]
]
