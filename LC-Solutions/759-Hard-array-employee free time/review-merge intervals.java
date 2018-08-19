/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Aug 18, 2018
 Problem:    employee free time
 Difficulty: hard
 Notes:

We are given a list schedule of employees, which represents the working time for each employee.

Each employee has a list of non-overlapping Intervals, and these intervals are in sorted order.

Return the list of finite intervals representing common, positive-length free time for all employees, also in sorted order.

Example 1:
Input: schedule = [[[1,2],[5,6]],[[1,3]],[[4,10]]]
Output: [[3,4]]
Explanation:
There are a total of three employees, and all common
free time intervals would be [-inf, 1], [3, 4], [10, inf].
We discard any intervals that contain inf as they aren't finite.
Example 2:
Input: schedule = [[[1,3],[6,7]],[[2,4]],[[2,5],[9,12]]]
Output: [[5,6],[7,9]]
(Even though we are representing Intervals in the form [x, y], the objects inside are Intervals, not lists or arrays. For example, schedule[0][0].start = 1, schedule[0][0].end = 2, and schedule[0][0][0] is not defined.)

Also, we wouldn't include intervals like [5, 5] in our answer, as they have zero length.

Note:

schedule and schedule[i] are lists with lengths in range [1, 50].
0 <= schedule[i].start < schedule[i].end <= 10^8.

*/

// 24ms 57%
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
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        // sort all intervals
        List<Interval> schedules = new ArrayList<>();
        for(List<Interval> list: schedule) {
            for(Interval i: list) {
                schedules.add(i);
            }
        }
        Collections.sort(schedules, new Comparator<Interval>(){
           public int compare(Interval i1, Interval i2) {
               if(i1.start != i2.start) return (i1.start - i2.start);
               else return (i1.end - i2.end);
           } 
        });
        // merge overlapped intervals
        List<Interval> merged = new ArrayList<>();
        Interval cur = schedules.get(0);
        for(int i = 1; i < schedules.size(); i++) {
            if(schedules.get(i).start > cur.end) {
                merged.add(cur);
                cur = schedules.get(i);
            } else {
                if(schedules.get(i).end > cur.end)
                    cur.end = schedules.get(i).end;
            }
        }
        merged.add(cur);
        
        // results
        List<Interval> res = new ArrayList<>();
        if(merged.size() < 2) return res;
        int start = 0, end = 0;
        for(int i = 1; i < merged.size(); i++) {
            start = merged.get(i-1).end;
            end = merged.get(i).start;
            res.add(new Interval(start, end));
        }
        return res;
    }
}