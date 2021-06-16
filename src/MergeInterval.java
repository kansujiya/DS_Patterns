import java.util.LinkedList;
import java.util.List;

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

/*
Given a list of intervals, merge all the overlapping intervals to produce a list that has only mutually exclusive intervals.

Example 1:

Intervals: [[1,4], [2,5], [7,9]]
Output: [[1,5], [7,9]]
Explanation: Since the first two intervals [1,4] and [2,5] overlap, we merged them into
one [1,5].


* */
class MergeInterval {
    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> mergeIntervals = new LinkedList<Interval>();

        return mergeIntervals;
    }
}
