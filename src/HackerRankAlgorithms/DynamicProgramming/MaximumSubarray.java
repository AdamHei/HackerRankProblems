package HackerRankAlgorithms.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.util.Arrays;

/**
 * Created by Adam on 5/22/2016.
 */
public class MaximumSubarray {

    static int[][] memoization;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine().trim());

        for (int i = 1; i <= cases; i++){
            br.readLine();
            int[] arr = toIntArray(br.readLine().split(" "));
            memoization = new int[arr.length][arr.length];
            for (int j = 0; j < memoization.length; j++){
                for (int k = 0; k < memoization.length; k++){
                    memoization[j][k] = Integer.MIN_VALUE;
                }
            }
            int nonContig = nonContig(arr);
            int contig = contig(arr);
            System.out.println(contig + " " + nonContig);
        }
    }

    private static int nonContig(int[] arr){
        int[] temp = Arrays.copyOf(arr, arr.length);
        Arrays.sort(temp);
        int max = temp[temp.length - 1];
        for (int i = temp.length - 2; i >= 0; i--){
            if (max + temp[i] > max){
                max += temp[i];
            }
            else{
                i = -1;
            }
        }
        return max;
    }

    private static int contig(int[] arr){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++){
            for (int j = arr.length - 1; j >= i; j--){
                int sum = sumFrom(arr, i, j);
                max = Math.max(sum, max);
            }
        }
        return max;
    }

    private static int sumFrom(int[] arr, int i, int j){
        if (memoization[i][j] != Integer.MIN_VALUE){
            return memoization[i][j];
        }
        int sum = 0;
        for (int temp = i; temp <= j; temp++){
            if (memoization[temp][j] != Integer.MIN_VALUE){
                sum += memoization[temp][j];
                temp = j + 1;
            }
            else{
                memoization[i][temp] = (sum += arr[temp]);
            }
        }
        memoization[i][j] = sum;
        return sum;
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }
}
