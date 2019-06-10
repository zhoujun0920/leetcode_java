class Solution {
  public int[] prisonAfterNDays(int[] cells, int N) {
      Map<Integer, Integer> map = new HashMap<>();
      map.put(toIntValue(cells), N--);
      int previous = toNext(cells, 0);
      while (N > 0) {
          int temp = toIntValue(cells);
          if (map.containsKey(temp)) {
              int t = map.get(temp) - N;
              N %= t;
              while (N > 0) {
                  previous = toNext(cells, previous);
                  N--;
              }
              break;
          } else {
              map.put(temp, N--);
          }
          previous = toNext(cells, previous);
      }
      return cells;
  }

  private int toNext(int[] cells, int previous) {
      for (int i = 0; i < cells.length; i++) {
          if (i == 0 || i == cells.length - 1) {
              previous = cells[i];
              cells[i] = 0;
          } else {
              if (previous == cells[i + 1]) {
                  previous = cells[i];
                  cells[i] = 1;
              } else {
                  previous = cells[i];
                  cells[i] = 0;
              }
          }
      }
      return previous;
  }

  private int toIntValue(int[] cells) {
      int state = 0;
      for (int i = 0; i < 8; i++) {
          state ^= cells[i] << i;
      }
      return state;
  }
}
