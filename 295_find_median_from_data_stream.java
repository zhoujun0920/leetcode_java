class MedianFinder {
    List<Integer> list;

    /** initialize your data structure here. */
    public MedianFinder() {
      list = new ArrayList<>();
    }

    public void addNum(int num) {
      if (list.size() == 0) {
        list.add(num);
          return;
      }
      if (num <= list.get(0)) {
          list.add(0, num);
          return;
      }
      if (num >= list.get(list.size() - 1)) {
          list.add(num);
          return;
      }
      for (int i = 0; i < list.size(); i++) {
        if (num < list.get(i)) {
          list.add(i, num);
          return;
        }
      }
      list.add(num);
    }

    public double findMedian() {
      int n = list.size();
      if (n == 0) {
        return 0;
      }
      if (n % 2 == 0) {
        return (list.get(n / 2 - 1) + list.get(n / 2)) / 2.0;
      }
      return list.get(n / 2);
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

// binary insert
 class MedianFinder {
     List<Integer> list;

     /** initialize your data structure here. */
     public MedianFinder() {
       list = new ArrayList<>();
     }

     public void addNum(int num) {
       if (list.size() == 0) {
         list.add(num);
           return;
       }
       if (num <= list.get(0)) {
           list.add(0, num);
           return;
       }
       if (num >= list.get(list.size() - 1)) {
           list.add(num);
           return;
       }
       myInsert(num, 0, list.size() - 1);
     }

     // 2, 6, 6, 10
     private void myInsert(int num, int start, int end) {
       int m = (start + end) / 2;
       if (list.get(m) < num) {
         if (list.get(m + 1) > num) {
           list.add(m + 1, num);
           return;
         }
         myInsert(num, m, end);
       } else if (list.get(m) > num) {
         if (list.get(m - 1) < num) {
           list.add(m, num);
           return;
         }
         myInsert(num, start, m);
       } else {
         list.add(m, num);
         return;
       }
     }

     public double findMedian() {
       int n = list.size();
       if (n == 0) {
         return 0;
       }
       if (n % 2 == 0) {
         return (list.get(n / 2 - 1) + list.get(n / 2)) / 2.0;
       }
       return list.get(n / 2);
     }
 }

// self balace tree, AVL tree,
// Heaps
// 
 class MedianFinder {
     /** initialize your data structure here. */
     public MedianFinder() {

     }

     public void addNum(int num) {

     }

     public double findMedian() {

     }
 }
