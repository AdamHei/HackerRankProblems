package Contests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Adam on 9/28/2016.
 */
public class LearningFromThePast {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine().trim());

        int total = 0;
        for (int i = 1; i <= cases; i++){
            int[] prices = toIntArray(br.readLine().split(" "));
            Arrays.sort(prices);
            total = Math.max(total, prices[1] + prices[2]);
        }

        System.out.println(total);
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }
}
