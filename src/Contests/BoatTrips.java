package Contests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Adam on 1/14/2017.
 */
public class BoatTrips {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] ncm = toIntArray(br.readLine().split(" "));
        int[] passengers = toIntArray(br.readLine().split(" "));

        int capacity = ncm[1] * ncm[2];

        int max = Arrays.stream(passengers).max().getAsInt();

        System.out.println(max > capacity ? "No" : "Yes");
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }
}
