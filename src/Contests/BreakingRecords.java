package Contests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Adam on 2/17/2017.
 */
public class BreakingRecords {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.readLine();
        int[] arr = toIntArray(br.readLine().split(" "));

        int min = arr[0], max = arr[0];
        int bestCount = 0, worstCount = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max){
                bestCount++;
                max = arr[i];
            }
            else if (arr[i] < min) {
                worstCount++;
                min = arr[i];
            }
        }

        System.out.println(bestCount + " " + worstCount);
    }

    private static int[] toIntArray(String[] strArr) {
        int[] arr = new int[strArr.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }
        return arr;
    }
}
