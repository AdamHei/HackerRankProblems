package Misc;

import org.jetbrains.annotations.Contract;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Adam on 6/12/2016.
 */
public class playground {
    //Created by Adam
    public static void main(String[] args) throws IOException {
        int[] coins = {10, 12, 6, 4, 1, 3, 15, 9};
        System.out.println(newMaxScore(coins, 0, coins.length - 1)); //32
    }

    private static int newMaxScore(int[] coins, int i, int j){
        if (i == j) return coins[i];
        if (i + 1 == j) return Math.max(coins[i], coins[j]);

        int max1 = coins[i] + Math.min(
                newMaxScore(coins, i + 2, j),
                newMaxScore(coins, i + 1, j - 1)
        );
        int max2 = coins[j] + Math.min(
                newMaxScore(coins, i + 1, j - 1),
                newMaxScore(coins, i, j - 2)
        );
        return Math.max(max1, max2);
    }

    private static int maxScore(int[] coins, int i, int j){
        if (i + 1 == j) {
            return Math.max(coins[i], coins[j]);
        }
        int i1, i2, j1, j2;
        //We're taking coins[i]
        if (coins[i + 1] > coins[j]){
            i1 = i + 2;
            j1 = j;
        }
        else {
            i1 = i + 1;
            j1 = j - 1;
        }
        //We're taking coins[j]
        if (coins[j - 1] > coins[i]){
            j2 = j - 2;
            i2 = i;
        }
        else {
            j2 = j - 1;
            i2 = i + 1;
        }
        int max1 = coins[i] + maxScore(coins, i1, j1);
        int max2 = coins[j] + maxScore(coins, i2, j2);
//        System.out.println(max1 + " " + max2);
        return Math.max(max1, max2);
//        return Math.max(
//                coins[i] + maxScore(coins, i1, j1),
//                coins[j] + maxScore(coins, i2, j2)
//        );
    }

    private static int minCoins(int n, int v1, int v2, int v3, Map<Integer, Integer> memo) {
        if (n < 0) return Integer.MAX_VALUE;
        if (n == 0 || n == 1) return n;
        if (memo.containsKey(n))
            return memo.get(n);
        int min1 = minCoins(n - v1, v1, v2, v3, memo),
                min2 = minCoins(n - v2, v1, v2, v3, memo),
                min3 = minCoins(n - v3, v1, v2, v3, memo);
        memo.put(n, 1 + Math.min(min1, Math.min(min2, min3)));
        return memo.get(n);
    }

    @Contract(pure = true)
    static int LIS(int[] arr) {
        int[] subsequence = new int[arr.length];
        subsequence[0] = arr[0];
        int lastElement = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < subsequence[0]) {
                subsequence[0] = arr[i];
            } else if (arr[i] > subsequence[lastElement]) {
                lastElement++;
                subsequence[lastElement] = arr[i];
            } else {
                int toReplace = binarySearch(subsequence, arr[i], -1, lastElement);
                subsequence[toReplace] = arr[i];
            }
        }
        return lastElement + 1;
    }

    @Contract(pure = true)
    private static int binarySearch(int[] arr, int k, int left, int right) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    static int kadanesAlgo(int[] arr) {
        int max_to_here = 0, max_so_far = 0;
        for (int i : arr) {
            max_to_here = Math.max(max_to_here + i, 0);
            max_so_far = Math.max(max_to_here, max_so_far);
        }

        return max_so_far;
    }

    static double binarySearch(double d) {
        double previousGuess = d / 2;

        double leftBound = 0, rightBound = d;

        for (int i = 0; i < 10000; i++) {
            double temp = previousGuess;
            previousGuess = (leftBound + rightBound) / 2;

            if (temp * temp > d) {
                rightBound = temp;
            } else {
                leftBound = temp;
            }
        }

        return previousGuess;
    }

    static double sqrt(double d) {
        double previousX = d / 2;

        for (int i = 0; i < 100; i++) {
            previousX = .5 * (previousX + d / previousX);
        }

        return previousX;
    }
}
