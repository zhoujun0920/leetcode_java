public class ZigzagIterator {

    int i = 0;
    int j = 0;

    List<Integer> l1;
    List<Integer> l2;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
      l1 = v1;
      l2 = v2;
    }

    public int next() {
      if (i <= j) {
        if (i == l1.size()) {
          return l2.get(j++);
        } else {
          return l1.get(i++);
        }
      } else {
        if (j == l2.size()) {
          return l1.get(i++);
        } else {
          return l2.get(j++);
        }
      }
    }

    public boolean hasNext() {
      return i < l1.size() || j < l2.size();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
