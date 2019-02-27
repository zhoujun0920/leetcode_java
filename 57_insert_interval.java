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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
      if (intervals.size() == 0) {
        intervals.add(newInterval);
        return intervals;
      }
      if (intervals.size() == 1) {
        Interval interval = intervals.get(0);
        if (interval.end < newInterval.start) {
          intervals.add(newInterval);
          return intervals;
        }
        if (newInterval.end < interval.start) {
          intervals.add(newInterval, 0);
          return intervals;
        }
        interval.start = interval.start > newInterval.start ? newInterval.start : interval.start;
        interval.end = interval.end > newInterval.end ? interval.end : newInterval.end;
        return intervals;
      }
      for (int i = 0; i < intervals.size() - 1; i++) {
        Interval interval1 = intervals.get(i);
        Interval interval2 = intervals.get(i + 1);
        if (newInterval.start > interval1.end) {
          continue;
        }
        if (newInterval.end < interval1.start) {
          intervals.add(0, newInterval);
          return intervals;
        }
        if (newInterval.start < interval1.start) {
          interval1.start = newInterval.start;
        }
        if (newInterval.end < interval2.start) {
          interval1.end = newInterval.end;
          return intervals;
        } else if (newInterval.end <= interval2.end) {
          interval1.end = interval2.end;
          intervals.remove(i + 1);
          return intervals;
        } else {
          while (newInterval.end > interval2.end) {
            intervals.remove(i + 1);
            if (i + 1 < intervals.size()) {
              interval2 = intervals.get(i + 1);
            } else {
              interval1.end = newInterval.end;
              return intervals;
            }
          }
          if (newInterval.end < interval2.start) {
            interval1.end = newInterval.end;
            return intervals;
          } else {
            interval1.end = interval2.end;
            intervals.remove(i + 1);
            return intervals;
          }
        }
      }
      Interval interval = intervals.get(intervals.size() - 1);
      if (interval.end >= newInterval.start) {
        interval.start = interval.start > newInterval.start? newInterval.start : interval.start;
        interval.end = interval.end > newInterval.end? interval.end : newInterval.end;
      } else {
        intervals.add(newInterval);
      }
      return intervals;
    }

    public class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
    }
}

class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
      if (intervals.size() == 0) {
        intervals.add(newInterval);
        return intervals;
      }
      for (int i = 0; i < intervals.size(); i++) {
        Interval temp1 = intervals.get(i);
        if (temp1.start > newInterval.end) {
          intervals.add(i, newInterval);
          return intervals;
        }
        if (temp1.end < newInterval.start) {
          continue;
        }
        temp1.start = temp1.start > newInterval.start ? newInterval.start : temp1.start;
        if (i + 1 < intervals.size()) {
          Interval temp2 = intervals.get(i + 1);
          while (temp2.end < newInterval.end) {
            intervals.remove(i + 1);
            if (i + 1 >= intervals.size()) {
              temp1.end = temp1.end > newInterval.end ? temp1.end : newInterval.end;
              return intervals;
            }
            temp2 = intervals.get(i + 1);
          }
          if (temp2.start > newInterval.end) {
            temp1.end = temp1.end > newInterval.end ? temp1.end : newInterval.end;
          } else {
            temp1.end = temp2.end;
            intervals.remove(i + 1);
          }
        } else {
          temp1.end = temp1.end > newInterval.end ? temp1.end : newInterval.end;
        }
        return intervals;
      }
      intervals.add(newInterval);
      return intervals;
    }

    public class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
    }
}

// instead of remove from original list, create a new list will be faster.
// remove takes O(n)
class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
      List<Interval> result = new ArrayList<>();
      
      return result;
    }

    public class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
    }
}
