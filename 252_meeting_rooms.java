/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
      Arrays.sort(intervals, (i, j) -> i[0] < j[0]);
      for (int i = 0; i < intervals.length - 1; i++) {
        if (interval[i][1] > interval[i + 1][0]) {
          return false;
        }
      }
      return true;
    }
}


class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
      quickSort(intervals, 0, intervals.length - 1);
      for (int i = 0; i < intervals.length - 1; i++) {
        Interval temp1 = intervals[i];
        Interval temp2 = intervals[i + 1];
        if (temp1.end > temp2.start) {
          return false;
        }
      }
      return true;
    }

    private void quickSort(Interval[] intervals, int start, int end) {
      if (start < end) {
        int temp = partition(intervals, start, end);
        quickSort(intervals, start, temp - 1);
        quickSort(intervals, temp + 1, end);
      }
    }

    private int partition(Interval[] intervals, int start, int end) {
      Interval pivot = intervals[end];
      int i = start;
      for (int j = start; j < end; j++) {
        Interval k = intervals[j];
        if (k.start < pivot.start) {
          int tempStart = k.start;
          int tempEnd = k.end;
          k.start = intervals[i].start;
          k.end = intervals[i].end;
          intervals[i].start = tempStart;
          intervals[i].end = tempEnd;
          i++;
        }
      }
      int tempStart = pivot.start;
      int tempEnd = pivot.end;
      pivot.start = intervals[i].start;
      pivot.end = intervals[i].end;
      intervals[i].start = tempStart;
      intervals[i].end = tempEnd;
      return i;
    }

    public class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
    }
}
