package Contests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

/**
 * Created by Adam on 6/28/2016.
 */
public class AltLazySort {
    public static void main(String[] args) throws IOException {
        long[] factsArr = new long[19];
        factsArr[0] = factsArr[1] = 1;
        for (int i = 2; i < 19; i++){
            factsArr[i] = factsArr[i - 1] * i;
        }

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        br.readLine();
//
//        int[] arr = toIntArray(br.readLine().split(" "));
        int[] arr = {1,2,3,4,4};
        int[] map = new int[101];

        for (int i: arr){
            map[i]++;
        }

        double summation = (double) factsArr[arr.length];

        for (int i: map){
            summation = summation / factsArr[i];
        }

        BigDecimal res = new BigDecimal(summation);
        res = res.setScale(6, BigDecimal.ROUND_CEILING);

        System.out.println(res);
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }
}
