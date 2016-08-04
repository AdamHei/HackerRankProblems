package HackerRankAlgorithms.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Adam on 8/3/2016.
 */
public class LargestPermutation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nandk = toIntArray(br.readLine().split(" "));
        int k = nandk[1];

        int[] arr = toIntArray(br.readLine().split(" "));

        if (k > arr.length){
            Arrays.sort(arr);
            printReverse(arr);
            System.exit(0);
        }

        int[] indices = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++){
            indices[arr[i]] = i;
        }

        int count = 0;
        int len = arr.length;
        for (int i = 0; i < len && count < k; i++){
            if (arr[i] == len - i){
                continue;
            }
            //Set the place in the array of the next max to be this element we just crossed
            arr[indices[len - i]] = arr[i];
            //Update the index of the element we just crossed to reflect the index of the max
            indices[arr[i]] = indices[len - i];
            //Update the array position to be the next max natural number
            arr[i] = len - i;
            //Update the index of the next max natural number
            indices[len - i] = i;
            count++;
        }

        print(arr);
    }

    private static void printReverse(int[] arr){
        for (int i = arr.length - 1; i >= 0; i--){
            System.out.print(arr[i] + " ");
        }
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void print(List<Integer> list){
        for (int i: list){
            System.out.print(i + " ");
        }
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }

    public static void print(int[] arr){
        for (int i: arr) {
            System.out.print(i + " ");
        }
    }
}
