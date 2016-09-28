package HackerRankAlgorithms.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Adam on 9/9/2016.
 */
public class InsertionSortAdvancedAnalysis {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int queries = Integer.parseInt(br.readLine().trim());

        for (int i = 1; i <= queries; i++){
            String s = br.readLine();
            String[] arr = br.readLine().split(" ");
            insertionSort(toIntArray(arr));
            System.out.println();
//            int[] arr = toIntArray(br.readLine().split(" "));
//            insertionSort(arr);
        }
    }

    private static void insertionSort(int[] arr){
        int count = 0;
        for (int i = 0; i < arr.length; i++){
            int minIndex = findMinIndex(arr, i);
            swap(arr, i, minIndex);
            if (minIndex - i > 1){
                count += (minIndex - i - 1);
            }
        }
        System.out.println(count);
    }

    private static int findMinIndex(int[] arr, int i){
        int min = arr[i];
        int minIndex = i;
        for (int j = i; j < arr.length; j++){
            if (arr[j] < min){
                min = arr[j];
                minIndex = j;
            }
        }
        return minIndex;
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
