class RandomizedCollection {
    List<Integer> index;
        Map<Integer, TreeSet<Integer>> value;
        Random rand;

        /** Initialize your data structure here. */
        public RandomizedCollection() {
            index = new ArrayList<>();
            value = new HashMap<>();
            rand = new Random();
        }

        /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
        public boolean insert(int val) {
            boolean isNew = !value.containsKey(val);
            TreeSet<Integer> l = value.getOrDefault(val, new TreeSet<>());
            l.add(index.size());
            value.put(val, l);
            index.add(val);
            return isNew;
        }

        /** Removes a value from the collection. Returns true if the collection contained the specified element. */
        public boolean remove(int val) {
            if (!value.containsKey(val)) {
                return false;
            }
            Integer lastValue = index.get(index.size() - 1);
            TreeSet<Integer> positions = value.get(val);
            Integer lastPosition = positions.pollLast();
            index.set(lastPosition, lastValue);
            index.remove(index.size() - 1);
            if (val != lastValue) {
                TreeSet<Integer> swapPositions = value.get(lastValue);
                swapPositions.pollLast();
                swapPositions.add(lastPosition);
                value.put(lastValue, swapPositions);
            }
            if (positions.size() > 0) {
                value.put(val, positions);
            } else {
                value.remove(val);
            }
            return true;
        }

        /** Get a random element from the collection. */
        public int getRandom() {
            int r = rand.nextInt(index.size());
            return index.get(r);
        }
}
