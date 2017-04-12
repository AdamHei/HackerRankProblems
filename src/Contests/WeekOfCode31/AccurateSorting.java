package Contests.WeekOfCode31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AccurateSorting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cases = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < cases; i++) {
            br.readLine();
            int[] arr = toIntArray(br.readLine().split(" "));

            System.out.println(canSort(arr) ? "Yes" : "No");
        }
    }

    private static boolean canSort(int[] arr){
        while (!sorted(arr)){
            boolean swapped = findAndSwap(arr);
            if (!swapped){
                return false;
            }
        }
        return true;
    }

    private static boolean findAndSwap(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1] && Math.abs(arr[i] - arr[i + 1]) <= 1){
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
                return true;
            }
        }
        return false;
    }

    private static boolean sorted(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]){
                return false;
            }
        }
        return true;
    }

    private static int[] toIntArray(String[] strArr) {
        int[] arr = new int[strArr.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }
        return arr;
    }
}
