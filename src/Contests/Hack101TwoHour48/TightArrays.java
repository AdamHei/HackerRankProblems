package Contests.Hack101TwoHour48;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class TightArrays {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] abc = toIntArray(br.readLine().split(" "));
        int a = abc[0], b = abc[1], c = abc[2];

        int diff1 = Math.abs(a - b) + 1;
        int diff2 = Math.abs(c - b);

        System.out.println(diff1 + diff2);
    }

    private static int[] toIntArray(String[] strArr) {
        int[] arr = new int[strArr.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }
        return arr;
    }
}
