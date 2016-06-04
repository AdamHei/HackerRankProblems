package HackerRankAlgorithms.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Adam on 5/17/2016.
 */
public class CoinChange {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = toIntArray(br.readLine().split(" "))[0];
        int[] arr = toIntArray(br.readLine().split(" "));
        int m = arr.length;

        Arrays.sort(arr);

        System.out.println("First method: " + count(arr, m, n));
        System.out.println("Second method: " + fasterCount(arr, m, n));
        System.out.println("Third method: " + fastestCount(arr, m, n));

//        System.out.println(fastestCount(arr, m, n));
    }

    private static int count(int[] arr, int m, int n){
        if (n == 0) return 1;
        if (n < 0) return 0;
        if (m <= 0 && n >= 1) return 0;
        return count(arr, m - 1, n) + count(arr, m, n - arr[m-1]);
    }

    private static long fasterCount(int[] arr, int m, int n){
        long table[][] = new long[n + 1][m];
        for (int i = 0; i < m; i++){
            table[0][i] = 1;
        }
        for (int i = 1; i < n + 1; i++){
            for (int j = 0; j < m; j++){
                long x = (i - arr[j] >= 0) ? table[i - arr[j]][j] : 0;

                long y = (j >= 1) ? table[i][j - 1] : 0;

                table[i][j] = x + y;
            }
        }

        return table[n][m-1];
    }

    private static long fastestCount(int[] arr, int m, int n){
        long[] table = new long[n + 1];

        Arrays.fill(table, 0);

        table[0] = 1;

        for (int i = 0; i < m; i++){
            for (int j = arr[i]; j <= n; j++){
                table[j] += table[j - arr[i]];
            }
        }
        return table[n];
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }
}
