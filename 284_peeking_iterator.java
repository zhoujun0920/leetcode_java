// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator<T> implements Iterator<T> {

        private T nextValue;
        private Iterator<T> itr;

        public PeekingIterator(Iterator<T> iterator) {
            this.itr = iterator;
            nextValue = itr.next();
        }

        // Returns the next element in the iteration without advancing the iterator.
        public T peek() {
            return nextValue;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public T next() {
            T ret = nextValue;
            nextValue = itr.hasNext() ? itr.next() : null;
            return ret;
        }

        @Override
        public boolean hasNext() {
            return nextValue != null;
        }
    }
