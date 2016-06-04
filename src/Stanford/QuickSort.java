package Stanford;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Adam on 5/13/2016.
 */
public class QuickSort {

    private static Random rand;

    public static void main(String[] args){
        rand = new Random();

        int[] arr = {6, 5};

        System.out.println(Arrays.toString(arr));
        quickSortRec(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSortRec(int[] arr, int start, int end){
        if (start >= end - 1) return;
        swap(arr, start, start + rand.nextInt(end - start));
        int pivot = partition(arr, start, end);
        quickSortRec(arr, start, pivot);
        quickSortRec(arr, pivot + 1, end);
    }

    private static int partition(int[] arr, int start, int end){
        int pivot = start;
        boolean flag = false;
        for (int i = start + 1; i < end; i += 1){
            if (arr[i] < arr[start] || (arr[i] == arr[start] && (flag = !flag))){
                pivot += 1;
                swap(arr, pivot, i);
            }
        }
        swap(arr, start, pivot);
        return pivot;
    }

    private static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
