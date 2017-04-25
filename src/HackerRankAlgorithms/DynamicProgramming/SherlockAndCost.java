package HackerRankAlgorithms.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SherlockAndCost {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cases = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < cases; i++) {
            br.readLine();
            int[] arr = toIntArray(br.readLine().split(" "));
            int len = arr.length;

            int[] minCurr = new int[len];
            int[] maxCurr = new int[len];
            minCurr[0] = 0;
            maxCurr[0] = 0;

            for (int j = 1; j < len; j++) {
                minCurr[j] = Math.max(minCurr[j - 1], maxCurr[j - 1] + arr[j - 1] - 1);
                maxCurr[j] = Math.max(minCurr[j - 1] + arr[j] - 1, maxCurr[j - 1] + Math.abs(arr[j - 1] - arr[j]));
            }

            System.out.println(Math.max(minCurr[len - 1], maxCurr[len - 1]));
        }
    }

    private static int[] toIntArray(String[] strArr) {
        int[] arr = new int[strArr.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }
        return arr;
    }
}
