package HackerRankAlgorithms.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * Created by Adam on 5/14/2016.
 */
public class HRQuicksortInPlace {

    static Random rand = new Random();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

        int[] arr = toIntArray(br.readLine().split(" "));

//        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
//        System.out.println(Arrays.toString(arr));
    }

    //Pass in arr.length for right
    private static void quickSort(int[] arr, int left, int right){
//        if (left >= right - 1){
//            return;
//        }
        if (left >= right){
            return;
        }
        int pivot = partition(arr, left, right);
        print(arr);
        System.out.println();
        quickSort(arr, left, pivot - 1);
        quickSort(arr, pivot + 1, right);
    }

    private static int partition(int[] arr, int left, int right){
        int pivot = arr[right];
        int i = left;
        int j;
        for (j = left; j < right; j += 1){
            if (arr[j] < pivot){
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, j);
//        print(arr);
//        System.out.println();
        return i;
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void print(int[] arr){
        for (int i: arr){
            System.out.print(i + " ");
        }
    }

    static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }
}
