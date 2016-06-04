package HackerRankAlgorithms.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Adam on 5/14/2016.
 */
public class BiggerIsGreater {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        int count = 1;
        for (int i = 1; i <= testCases; i += 1){
            if (count == 38772){
                String temp = br.readLine();
                System.out.println(temp);
            }
            if (count == 38773){
                System.out.println(count);
                System.out.println(br.readLine());
            }
            count++;
            lexography(br.readLine().toCharArray());
        }
    }

    private static void lexography(char[] arr){
        if (arr.length == 1){
//            System.out.println("no answer");
            return;
        }
        int j = arr.length - 1;
        while (j >= 1 && arr[j - 1] >= arr[j]){
            j--;
        }
        if (j == 0){
//            System.out.println("no answer");
            return;
        }
        char c = arr[j - 1];
        char minMax = 'z';
        int index = 0;
        for (int i = j; i < arr.length; i += 1){
            if (arr[i] > c && arr[i] <= minMax){
                minMax = arr[i];
                index = i;
            }
        }

        swap(arr, index, j - 1);

        //Sorting is a waste of time
//            sort(arr, j, arr.length);

        reverse(arr, j, arr.length);

//        print(arr);
    }

    private static void reverse(char[] arr, int j, int length){
        int last = length - 1;
        while (j < last){
            swap(arr, j, last);
            j++;
            last--;
        }
    }

    private static void print(char[] arr){
        for (char c: arr){
            System.out.print(c);
        }
        System.out.println();
    }

    private static void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
