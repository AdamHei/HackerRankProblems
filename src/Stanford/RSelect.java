package Stanford;

import java.util.Random;

/**
 * Created by Adam on 5/18/2016.
 */
public class RSelect {

    private static Random rand;

    public static void main(String[] args){
        rand = new Random();
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++){
            arr[i] = rand.nextInt(100);
        }

        for (int i = arr.length; i >= 1; i--){
            System.out.println(i + "th order statistic: " + arr[rQuickSelect(arr, 0, arr.length - 1, i) - 1]);
        }
    }

    /**
     * Returns the index of the k-th smallest element in the array
     * @param arr The array to be searched
     * @param start The starting index
     * @param end The ending index. To start, should be arr.length - 1
     * @param k The order statistic to be returned
     * @return The index of the k-th smallest element
     */
    private static int rQuickSelect(int[] arr, int start, int end, int k){
        int p;
        if (start < end){
            p = stupidPartition(arr, start, end);
            if (p == k) return p;
            else if (k < p) return rQuickSelect(arr, start, p - 1, k);
            else return rQuickSelect(arr, p + 1, end, k);
        }
        else return k;
    }

    private static int stupidPartition(int[] arr, int start, int end){
        int pVal;
//        pVal = start; //This is very bad
        pVal = rand.nextInt((end - start) + 1 + start);
//        start++;
        while (start < arr.length && arr[start] > arr[pVal]) start++;
        while (end >= 0 && arr[end] < arr[pVal]) end--;
        if (start < end) swap(arr, start, end);
        else swap(arr, pVal, end);

        return end;
    }

    private static int partition(int[] arr, int pivotIndex, int start, int end){
        int i = start + 1;
        int j = i;
//        int pivot = rand.nextInt((end - start) + 1 + start);
        for (; i < end; i++){
            if (arr[i] < arr[pivotIndex]){
                swap(arr, i, j);
                j++;
            }
        }
        if (j <= end){
            swap(arr, pivotIndex, (j - 1));
        }
        return j - 1;
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
