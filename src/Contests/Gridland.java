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
        int[] nmk = toIntArray(br.readLine().split(" "));
        int n = nmk[0];
        int m = nmk[1];
        int k = nmk[2];
        long totalCells = n * m;
        Map<Integer, List<Interval>> rowToEntries = new HashMap<>();

        for (int i = 0; i < k; i++) {
            int[] rcc = toIntArray(br.readLine().split(" "));
            List<Interval> intervals = new ArrayList<>();
            if (rowToEntries.containsKey(rcc[0])){
                intervals = rowToEntries.get(rcc[0]);
            }
            intervals.add(new Interval(rcc[1], rcc[2]));
            rowToEntries.put(rcc[0], intervals);
        }

        for (int row: rowToEntries.keySet()){
            List<Interval> intervals = rowToEntries.get(row);
            Collections.sort(intervals);

            int i = 0;
            Interval iter = intervals.get(i);
            int start = iter.start;
            int end = iter.end;

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
        int start, end;
        Interval(int a, int b){
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

        public boolean overlaps(Interval other){
            return this.start <= other.end && this.start >= other.start || this.end <= other.end && this.end >= other.start;
        }
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }
}
