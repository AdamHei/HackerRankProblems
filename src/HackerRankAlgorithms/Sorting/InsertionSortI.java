package HackerRankAlgorithms.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Adam on 5/11/2016.
 */
public class InsertionSortI {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

        String[] arr = br.readLine().split(" ");
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            newArr[i] = Integer.parseInt(arr[i]);
        }
        insertionSort(newArr);
    }

    private static void insertionSort(int[] arr) {
        int toPlace = arr[arr.length - 1];
        int index = arr.length - 2;
        while (arr[index] > toPlace) {
            if (index == 0){
                arr[index + 1] = arr[index];
                print(arr);
                arr[0] = toPlace;
                break;
            }
            arr[index + 1] = arr[index];
            print(arr);
            index -= 1;
        }
        if (arr[index] < toPlace){
            index += 1;
            arr[index] = toPlace;
        }
        print(arr);
    }

    private static void print(int[] arr){
        for (int i: arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
