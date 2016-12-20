package HackerRankAlgorithms.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Adam on 12/19/2016.
 */
public class MiniMaxSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[] arr = toLongArray(br.readLine().split(" "));

        Arrays.sort(arr);

        long min = Arrays.stream(arr).sum() - arr[arr.length - 1];
        long max = Arrays.stream(arr).sum() - arr[0];

        System.out.println(min + " " + max);
    }

    private static long[] toLongArray(String[] arr) {
        long[] toReturn = new long[arr.length];
        for (int i = 0; i < arr.length; i += 1) {
            toReturn[i] = Long.parseLong(arr[i]);
        }
        return toReturn;
    }
}
