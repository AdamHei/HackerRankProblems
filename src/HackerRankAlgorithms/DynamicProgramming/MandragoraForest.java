package HackerRankAlgorithms.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Adam on 10/17/2016.
 */
public class MandragoraForest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine().trim());

        for (int i = 1; i <= cases; i++){
            br.readLine();
            long[] arr = toIntArray(br.readLine().split(" "));
            Arrays.sort(arr);

            long s = arr.length;
            long max = Integer.MIN_VALUE;
            long battled = 0;

            for (int j = arr.length - 1; j >= 0 ; j--) {
                max = Math.max(max, s * (arr[j] + battled));
                battled += arr[j];
                s--;
            }

            System.out.println(max);
        }
    }

    private static long[] toIntArray(String[] arr){
        long[] toReturn = new long[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Long.parseLong(arr[i]);
        }
        return toReturn;
    }
}
