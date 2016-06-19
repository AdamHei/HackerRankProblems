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

    private static long[][] memoization;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine().trim());

        for (int i = 1; i <= cases; i++){
            br.readLine();
            long[] arr = toIntArray(br.readLine().split(" "));
//            memoization = new long[arr.length][arr.length];
//            for (int j = 0; j < memoization.length; j++){
//                for (int k = 0; k < memoization.length; k++){
//                    memoization[j][k] = Long.MIN_VALUE;
//                }
//            }
            long nonContig = nonContig(arr);
            long contig = max_subarray(arr);
            System.out.println(contig + " " + nonContig);
        }
    }

    private static long nonContig(long[] arr){
        long[] temp = Arrays.copyOf(arr, arr.length);
        Arrays.sort(temp);
        long max = temp[temp.length - 1];
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

    private static long max_subarray(long[] temp){
        long[] arr = Arrays.copyOf(temp, temp.length);
        long max_ending_here = arr[0];
        long max_so_far = arr[0];
        for (int i = 1; i < arr.length; i++){
            long x = arr[i];
            max_ending_here = Math.max(x, max_ending_here + x);
            max_so_far = Math.max(max_so_far, max_ending_here);
        }
        return max_so_far;
    }

    private static long contig(long[] arr){
        long max = Long.MIN_VALUE;
        for (int i = 0; i < arr.length; i++){
            for (int j = arr.length - 1; j >= i; j--){
                long sum = sumFrom(arr, i, j);
                max = Math.max(sum, max);
            }
        }
        return max;
    }

    private static long sumFrom(long[] arr, int i, int j){
        if (memoization[i][j] != Long.MIN_VALUE){
            return memoization[i][j];
        }
        long sum = 0;
        for (int temp = i; temp <= j; temp++){
            if (memoization[temp][j] != Long.MIN_VALUE){
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

    private static long[] toIntArray(String[] arr){
        long[] toReturn = new long[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Long.parseLong(arr[i]);
        }
        return toReturn;
    }
}
