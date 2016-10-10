package Contests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Adam on 10/10/2016.
 */
public class AppleAndOrange {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] st = toIntArray(br.readLine().split(" "));
        int[] ab = toIntArray(br.readLine().split(" "));
        br.readLine();
        int[] apples = toIntArray(br.readLine().split(" "));
        int[] oranges = toIntArray(br.readLine().split(" "));

        int s = st[0], t = st[1], a = ab[0], b = ab[1];

        int appleHits = 0, orangeHits = 0;
        for (int apple: apples){
            if (a + apple >= s && a + apple <= t) appleHits++;
        }
        for (int orange: oranges){
            if (b + orange <= t && b + orange >= s) orangeHits++;
        }
        System.out.println(appleHits);
        System.out.println(orangeHits);
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }
}
