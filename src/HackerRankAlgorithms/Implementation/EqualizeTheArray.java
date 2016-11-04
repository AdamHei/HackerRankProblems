package HackerRankAlgorithms.Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Adam on 11/4/2016.
 */
public class EqualizeTheArray {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.readLine();
        int[] arr = toIntArray(br.readLine().split(" "));

        int[] occurances = new int[101];

        for (int i: arr){
            occurances[i]++;
        }

        int max = Integer.MIN_VALUE;
        for (int i: occurances){
            max = Math.max(max, i);
        }

        System.out.println(arr.length - max == 0 ? 0 : arr.length - max);
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }

    private static long[] toLongArray(String[] arr){
        long[] toReturn = new long[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Long.parseLong(arr[i]);
        }
        return toReturn;
    }
}
