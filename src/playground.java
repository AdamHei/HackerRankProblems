import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Adam on 6/12/2016.
 */
public class playground {

    private static int[] memo;
    private static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
//        int[] arr = {2,3,4,1,5};
//
//        mergeSort(arr, 0, arr.length - 1);
//        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < 5; i++) {
            System.out.println(fibonacci(i));
        }
    }

    private static int fibonacci(int n){
        if (n == 0 || n == 1) return 1;
        if (map.containsKey(n)) return map.get(n);
        map.put(n, fibonacci(n - 1) + fibonacci(n - 2));
        return map.get(n);
    }

    private static void mergeSort(int[] arr, int left, int right){
        if (left >= right) return;
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        inPlaceMerge(arr, left, right);
    }

    private static void inPlaceMerge(int[] arr, int start, int end){
        if (start >= end) return;
        int i = start;
        int j = (start + end) / 2;
        if (i == j) j++;
        while (i <= end && j <= end){
            if (arr[i] <= arr[j]){
                i++;
            }
            else {
                swap(arr, i, j);
                j++;
            }
            if (i == j){
                j++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static boolean sameArray(int[] arr1, int[] arr2){
        int n = arr1.length;
        int i = 0;
        while (i < n){
            boolean found = false;
            int j = 0;
            while (j < n){
                if (arr1[i] == arr2[j]){
                    found = true;
                    break;
                }
                j++;
            }
            if (!found) {
                return false;
            }
            i += 1;
        }
        return true;
    }

    private static int numCombos(int n){
        if (n == 0) return 1;
        if (n < 0) return 0;
        if (memo[n] != 0) return memo[n];
        return memo[n] = numCombos(n -1) + numCombos(n - 2);
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }
}
