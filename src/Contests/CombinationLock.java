package Contests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Adam on 8/27/2016.
 */
public class CombinationLock {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] initial = toIntArray(br.readLine().split(" "));
        int[] desired = toIntArray(br.readLine().split(" "));

        int minRotations = 0;
        for (int i = 0; i < initial.length; i++){
            int noOverflow = Math.abs(initial[i] - desired[i]);
            int withOverflow = Math.abs((10 - Math.max(initial[i], desired[i])) + Math.min(initial[i], desired[i]));
            minRotations += Math.min(noOverflow, withOverflow);
        }
        System.out.println(minRotations);
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }

}
