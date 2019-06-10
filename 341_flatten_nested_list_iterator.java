/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    Deque<NestedInteger> deque;


    public NestedIterator(List<NestedInteger> nestedList) {
        deque = new LinkedList<>();
        for (NestedInteger n : nestedList) {
            if (!isEmpty(n)) {
                deque.add(n);
            }
        }
    }

    private boolean isEmpty(NestedInteger n) {
        if (n.isInteger()) {
            return false;
        }
        if (n.getList() == null || n.getList().size() == 0) {
            return true;
        }
        for (NestedInteger temp : n.getList()) {
            if (!isEmpty(temp)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Integer next() {
        NestedInteger n = deque.removeFirst();
        if (n.isInteger()) {
            return n.getInteger();
        }
        List<NestedInteger> temp = n.getList();
        for (int i = temp.size() - 1; i >= 0; i--) {
            if (!isEmpty(temp.get(i))) {
                deque.addFirst(temp.get(i));
            }

        }
        return next();
    }

    @Override
    public boolean hasNext() {
        return !deque.isEmpty();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
