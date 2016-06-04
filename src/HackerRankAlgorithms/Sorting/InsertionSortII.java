package HackerRankAlgorithms.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Adam on 5/11/2016.
 */
public class InsertionSortII {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

        String[] arr = br.readLine().split(" ");
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1) {
            newArr[i] = Integer.parseInt(arr[i]);
        }


//        System.out.println(Arrays.toString(newArr));
//        System.out.println();
        insertionSort(newArr);
//        System.out.println();
//        System.out.println(Arrays.toString(newArr));
    }

    private static void insertionSort(int[] arr){

        for (int i = 0; i < arr.length - 1; i += 1){
            int j = i + 1;
            while (j > 0){
                if (arr[j] < arr[j - 1]){
                    swap(arr, j, j - 1);
                    j --;
                }
                else{
                    break;
                }
            }
            print(arr);
        }
//        while (!isSorted(arr)){
//            int lastIndex = 0;
//            for (int index = 1; index < arr.length; index += 1){
//                if (arr[index] < arr[lastIndex]){
//                    swap(arr, index, lastIndex);
//                    print(arr);
//                }
////                else{
////                    print(arr);
////                }
//                lastIndex += 1;
//            }
//            int index = 0;
//            while (arr[index + 1] > arr[index]){
//                index += 1;
//            }
//            index += 1;
//            int temp = arr[index];
//            int toSwapWith = 0;
//            while (arr[toSwapWith] < temp){
//                toSwapWith += 1;
//            }
//            swap(arr, toSwapWith, index);
//            print(arr);
//        }
    }

    private static void print(int[] arr){
        for (int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void swap(int[] arr, int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    private static boolean isSorted(int[] arr){
        for (int i = 0; i < arr.length - 1; i += 1){
            if (arr[i + 1] < arr[i]){
                return false;
            }
        }
        return true;
    }
}