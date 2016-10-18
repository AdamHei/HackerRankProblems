package HackerRankAlgorithms.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Adam on 10/18/2016.
 */
public class NikitaAndTheGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine().trim());

        for (int i = 1; i <= cases; i++){
            br.readLine();
            long[] arr = toIntArray(br.readLine().split(" "));

            System.out.println(maxPartitionsRec(arr, 0, arr.length - 1));
        }
    }

    private static long maxPartitionsRec(long[] arr, int left, int right){
        if (left >= right){
            return 0;
        }

        long leftSum = 0, rightSum = 0;
        int leftIndex = left, rightIndex = right;
        while (leftIndex < rightIndex){
            if (leftSum < rightSum){
                leftSum += arr[leftIndex];
                leftIndex++;
            }
            else {
                rightSum += arr[rightIndex];
                rightIndex--;
            }
        }

        int nextMid = leftIndex;
        if (leftSum <= rightSum){
            leftSum += arr[leftIndex];
        }
        else {
            rightSum += arr[leftIndex];
            nextMid--;
        }

        if (leftSum != rightSum){
            return 0;
        }

        return 1 + Math.max(maxPartitionsRec(arr, left, nextMid), maxPartitionsRec(arr, nextMid + 1, right));
    }

    private static long[] toIntArray(String[] arr){
        long[] toReturn = new long[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Long.parseLong(arr[i]);
        }
        return toReturn;
    }
}
