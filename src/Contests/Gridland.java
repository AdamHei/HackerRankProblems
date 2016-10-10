package Contests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Adam on 9/24/2016.
 */
public class Gridland {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] nmk = toLongArray(br.readLine().split(" "));
        long n = nmk[0];
        long m = nmk[1];
        long k = nmk[2];
        long totalCells = n * m;
        Map<Long, List<Interval>> rowToEntries = new HashMap<>();

        for (int i = 0; i < k; i++) {
            long[] rcc = toLongArray(br.readLine().split(" "));
            List<Interval> intervals = new ArrayList<>();
            if (rowToEntries.containsKey(rcc[0])){
                intervals = rowToEntries.get(rcc[0]);
            }
            intervals.add(new Interval(rcc[1], rcc[2]));
            rowToEntries.put(rcc[0], intervals);
        }

        for (long row: rowToEntries.keySet()){
            List<Interval> intervals = rowToEntries.get(row);
            Collections.sort(intervals);

            int i = 0;
            Interval iter = intervals.get(i);
            long start = iter.start;
            long end = iter.end;

            if (intervals.size() == 1){
                totalCells -= (iter.end - iter.start + 1);
            }

            i++;
            while (i < intervals.size()){
                while (i < intervals.size() && intervals.get(i).overlaps(iter)){
                    iter = intervals.get(i);
                    end = Math.max(end, iter.end);
                    i++;
                }
                totalCells -= (end - start + 1);
                if (i < intervals.size()){
                    iter = intervals.get(i);
                    start = iter.start;
                    end = iter.end;
                }
            }
        }

        System.out.println(totalCells);
    }

    private static class Interval implements Comparable<Interval>{
        long start, end;
        Interval(long a, long b){
            this.start = a;
            this.end = b;
        }


        @Override
        public int compareTo(Interval o) {
            if (this.start < o.start){
                return -1;
            }
            else if (this.start > o.start){
                return 1;
            }
            else {
                if (this.end <= o.end){
                    return -1;
                }
                else {
                    return 1;
                }
            }
        }

        boolean overlaps(Interval other){
            return this.start <= other.end && this.start >= other.start || this.end <= other.end && this.end >= other.start;
        }
    }

    private static long[] toLongArray(String[] arr){
        long[] toReturn = new long[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Long.parseLong(arr[i]);
        }
        return toReturn;
    }
}
