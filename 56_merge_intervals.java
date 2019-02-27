/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

 //List get is O(1)
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
      int n = intervals.size();
      quickSort(intervals, 0, n - 1);
      List<Interval> result = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        Interval temp1 = intervals.get(i);
        if (i < n - 1) {
          Interval temp2 = intervals.get(i + 1);
          if (temp1.end < temp2.start) {
            result.add(temp1);
            continue;
          }
          temp2.start = temp1.start > temp2.start ? temp2.start : temp1.start;
          temp2.end = temp1.end > temp2.end ? temp1.end : temp2.end;
        } else {
          result.add(temp1);
        }
      }
      return result;
    }

    private void quickSort(List<Interval> intervals, int start, int end) {
      if (start < end) {
        int temp = partition(intervals, start, end);
        quickSort(intervals, start, temp - 1);
        quickSort(intervals, temp + 1, end);
      }
    }

    private int partition(List<Interval> intervals, int start, int end) {
      Interval pivot = intervals.get(end);
      int i = start;
      for (int j = start; j < end; j++) {
        Interval k = intervals.get(j);
        if (k.start < pivot.start) {
          int tempStart = k.start;
          int tempEnd = k.end;
          k.start = intervals.get(i).start;
          k.end = intervals.get(i).end;
          intervals.get(i).start = tempStart;
          intervals.get(i).end = tempEnd;
          i++;
        }
      }
      int tempStart = pivot.start;
      int tempEnd = pivot.end;
      pivot.start = intervals.get(i).start;
      pivot.end = intervals.get(i).end;
      intervals.get(i).start = tempStart;
      intervals.get(i).end = tempEnd;
      return i;
    }

    public class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
    }
}
