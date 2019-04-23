package array;

import java.util.*;

/**
 * Created by miula on 2019/4/13.
 *
 * @author miula
 * @date 2019/04/13
 */
public class MergeIntervals56 {
    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals.size() == 0){
            return res;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });

        Interval tmp = intervals.get(0);
        if (intervals.size() == 1){
            res.add(tmp);
            return res;
        }

        for (int i = 1; i < intervals.size(); i++){
            if (tmp.end >= intervals.get(i).start){
                tmp.end = Math.max(tmp.end, intervals.get(i).end);
            }else {
                res.add(tmp);
                tmp = intervals.get(i);
            }
            if (i == intervals.size() - 1){
                res.add(tmp);
            }
        }
        return res;
    }

    public static void main(String[] args){
        List<Interval> intervals = Arrays.asList(new Interval(1, 3), new Interval(2, 6),
            new Interval(8, 10), new Interval(15, 18));
        List<Interval> res = merge(intervals);
        System.out.println(res);
    }

}
