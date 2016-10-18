package Contests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Adam on 10/15/2016.
 */
public class MakingCandies {

    private static final int LOOPS = 100000;
    private static final int BILLION = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] arr = toLongArray(br.readLine().trim().split(" "));

        long m = arr[0], w = arr[1], p = arr[2], n = arr[3];

        System.out.println(findMinPasses(m, w, p, n));
    }

    private static long findMinPasses(long m, long w, long p, long n){
        MyEntry closest = findIdealFactors(m, w, n);

        long passes = 1;
        long candies = m * w;

        while (m * w < n){
            long toSpend = candies / p;
            candies -= toSpend;
            while (toSpend > 0){
                if (m < closest.left){
                    m++;
                }
                else {
                    w++;
                }
                toSpend--;
            }

            candies += m * w;
            passes++;
        }

        return passes;
    }

    private static MyEntry findIdealFactors(long m, long w, long n){
        long limit = (long) Math.sqrt(n);
        Set<Long> factors = new HashSet<>();
        List<MyEntry> factorPairs = new ArrayList<>();

        for (long i = 1; i <= limit; i++) {
            if (n % i == 0 && !factors.contains(i)){
                long other = n / i;
                factors.add(i);
                factors.add(other);
                factorPairs.add(new MyEntry(i, other));
            }
        }

        long minDifference = Long.MAX_VALUE;
        MyEntry target = new MyEntry(m, w);
        MyEntry closest = null;
        for (MyEntry entry: factorPairs){
            long difference = target.difference(entry);
            if (difference < minDifference){
                closest = entry;
                minDifference = difference;
            }
        }

        return closest;
    }

    private static class MyEntry {
        long left, right;

        MyEntry(long l, long r){
            left = l;
            right = r;
        }

        long difference(MyEntry other){
            return Math.abs(left - other.left) + Math.abs(right - other.right);
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
