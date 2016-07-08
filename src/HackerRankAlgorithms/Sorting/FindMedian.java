package HackerRankAlgorithms.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * Created by Adam on 7/7/2016.
 */
public class FindMedian {

    private static Random rand = new Random();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

        int[] arr = toIntArray(br.readLine().split(" "));

        if (arr.length % 2 == 1){
            int median = rQuickSelect(arr, 0, arr.length - 1, arr.length / 2);
            System.out.println(arr[median]);
        }
        else{
            int left = rQuickSelect(arr, 0, arr.length - 1, arr.length / 2);
            int right = rQuickSelect(arr, 0, arr.length - 1, arr.length / 2 + 1);
            double median = (arr[left] + arr[right]) / 2;
            System.out.println(median);
        }
    }

    /**
     * Returns the index of the k-th order statistic in the array
     */
    private static int rQuickSelect(int[] arr, int start, int end, int k){
        int p;
        if (start < end){
            p = randomPartition(arr, start, end);
            if (p == k) return p;
            else if (k < p) return rQuickSelect(arr, start, p - 1, k);
            else return rQuickSelect(arr, p + 1, end, k);
        }
        else return k;
    }

    private static int randomPartition(int[] arr, int start, int end){
        int pivotIndex = rand.nextInt((end - start) + 1) + start;
        int pivot = arr[pivotIndex];

        swap(arr, pivotIndex, end);
        pivotIndex = end;

        int i = start;
        for (int j = start; j < end; j++){
            if (arr[j] < pivot){
                swap(arr, j, i);
                i++;
            }
        }
        swap(arr, i, end);
        return i;
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }
}
