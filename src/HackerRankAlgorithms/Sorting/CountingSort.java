package HackerRankAlgorithms.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Adam on 7/28/2016.
 */
public class CountingSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine().trim());

        int[] arr = toIntArray(br.readLine().split(" "));
        int[] counts = new int[100];
        for (int i: arr){
            counts[i]++;
        }
        for (int i: counts){
            System.out.print(i + " ");
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
