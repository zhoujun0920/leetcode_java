public class NestedIterator implements Iterator<Integer> {

  Deque<NestedInteger> deque;

  public NestedIterator(List<NestedInteger> nestedList) {
      deque = new ArrayDeque<>();
      if (!isEmpty(nestedList)) {
          for (NestedInteger n : nestedList) {
            // check empty list
              if (n.getInteger() != null || !isEmpty(n.getList())) {
                  deque.add(n);
              }
          }
      }
  }

  private boolean isEmpty(List<NestedInteger> nestedList) {
      if (nestedList == null) {
          return false;
      }
      for (NestedInteger n : nestedList) {
          if (n.getInteger() != null) {
              return false;
          }
          if (!isEmpty(n.getList())) {
              return false;
          }
      }
      return true;
  }

  @Override
  public Integer next() {
      NestedInteger temp = deque.poll();
      return recursive(temp);
  }

  private Integer recursive(NestedInteger nestedInteger) {
      if (nestedInteger.isInteger()) {
          return nestedInteger.getInteger();
      }
      List<NestedInteger> temp = nestedInteger.getList();
      for (int i = temp.size() - 1; i >= 0; i--) {
          NestedInteger n = temp.get(i);
          // check empty list
          if (n.getInteger() != null || !isEmpty(n.getList())) {
                  deque.push(n);
              }
      }
      return recursive(deque.poll());
  }

  @Override
  public boolean hasNext() {
      return !deque.isEmpty();
  }
}


//[[[[]]],[]]
