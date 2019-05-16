class Vector2D {

  int i = 0;
  int j = 0;

  int[][] temp;

  public Vector2D(int[][] v) {
    temp = v;
    // be careful of empty array
      while (i< temp.length && temp[i].length == 0) {
          i++;
      }
  }

  public int next() {
    int value = temp[i][j];
    if (j == temp[i].length - 1) {
      i++;
      // be careful of empty array
      while (i < temp.length && temp[i].length == 0) {
          i++;
      }
      j = 0;
    } else {
      j++;
    }
      return value;
  }

  public boolean hasNext() {
    return i < temp.length && j < temp[i].length;
  }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(v);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
