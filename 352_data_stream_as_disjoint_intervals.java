/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class SummaryRanges {
  TreeMap<Integer, Integer> treeMap;

  /** Initialize your data structure here. */
  public SummaryRanges() {
   treeMap = new TreeMap<>();
  }

  public void addNum(int val) {
   if (treeMap.containsKey(val)) {
     return;
   }
   Integer floor = treeMap.floorKey(val);
   Integer ceiling = treeMap.ceilingKey(val);
   if (floor == null && ceiling == null) {
     treeMap.put(val, val);
   } else if (floor == null) {
     Integer end = treeMap.get(ceiling);
     if (val == ceiling - 1) {
       treeMap.remove(ceiling);
       treeMap.put(val, end);
     } else {
       treeMap.put(val, val);
     }
   } else if (ceiling == null) {
     Integer end = treeMap.get(floor);
     if (val > end) {
       if (val == end + 1) {
         treeMap.remove(floor);
         treeMap.put(floor, val);
       } else {
         treeMap.put(val,val);
       }
     }
   } else {
     Integer end1 = treeMap.get(ceiling);
     Integer end2 = treeMap.get(floor);
     if (val > end2) {
       if (val == end2 + 1 ) {
         if (val == ceiling - 1) {
           treeMap.remove(ceiling);
           treeMap.put(floor, end1);
         } else {
           treeMap.put(floor, val);
         }
       } else if (val == ceiling - 1) {
         treeMap.remove(ceiling);
         treeMap.put(val, end1);
       } else if(val != end1 && val != end2) {
         treeMap.put(val,val);
       }
     }
   }
  }

  public List<Interval> getIntervals() {
   List<Interval> temp = new ArrayList<>();
   for(Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
       Integer start = entry.getKey();
       Integer end = entry.getValue();
       Interval interval = new Interval(start, end);
       temp.add(interval);
   }
   return temp;
  }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */
