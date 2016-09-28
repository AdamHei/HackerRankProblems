package HackerRankAlgorithms.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Too slow joe
 */
public class SamandSubStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] digits = toIntArray(br.readLine().split(""));

        long total = 0;
        for (int i = 0; i < digits.length; i++) {
            for (int j = i; j < digits.length; j++) {
                total += sumFrom(i, j, digits);
            }
        }

        System.out.println(total % (1000000007));
    }

    private static long sumFrom(int i, int j, int[] digits){
        if (i == j){
            return digits[i];
        }

        int length = j - i + 1;
        long tempTotal = 0;

        for (int place = length; place >= 1; place--){
            long num = digits[i];
            for (int k = 1; k < place; k++) {
                num *= 10;
            }
            tempTotal += num;
            i++;
        }

        return tempTotal;
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }
}
