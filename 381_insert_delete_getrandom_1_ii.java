class RandomizedCollection {

    List<Integer> index;
    Map<Integer, List<Integer>> value;
    Random rand;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
      index = new ArrayList<>();
      value = new HashMap<>();
      rand = new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        List<Integer> l = value.getOrDefault(val, new ArrayList<>());
        l.add(index.size())
        value.put(val, l);
        index.add(val);
        return true;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
      if (!value.containsKey(val)) {
        return false;
      }
      Integer lastValue = index.get(index.size() - 1);
      List<Integer> positions = value.get(val);
      if (lastValue == val) {
          positions.remove(positions.size() - 1);
          index.remove(index.size() - 1);
          if (positions.size() > 0) {
            value.put(val, positions);
          } else {
            value.remove(val);
          }
      } else {
        Integer lastPosition = positions.get(positions.size() - 1);
        index.set(lastPosition, lastValue);
        index.remove(index.size() - 1);
        List<Integer> swapPositions = value.get(lastValue);
        swapPositions.set(swapPositions.size() - 1, lastPosition);
        value.put(lastValue, swapPositions);
        positions.remove(positions.size() - 1);
        if (positions.size() > 0) {
          value.put(val, positions);
        } else {
          value.remove(val);
        }
      }
      return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
      int r = rand.nextInt(index.size());
      return index.get(r);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
