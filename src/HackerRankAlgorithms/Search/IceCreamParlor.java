package HackerRankAlgorithms.Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Adam on 5/18/2016.
 */
public class IceCreamParlor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());

        for (int i = 1; i <= cases; i++){
            int m = Integer.parseInt(br.readLine());
            br.readLine();
            int[] arr = toIntArray(br.readLine().split(" "));
            findIndices(arr, m);
        }
    }

    private static void findIndices(int[] arr, int m){
        for (int i = 0; i < arr.length - 1; i++){
            for (int j = 1; j < arr.length; j++){
                if (i != j && arr[i] + arr[j] == m){
                    System.out.println((i + 1) + " " + (j + 1));
                    return;
                }
            }
        }
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }
}
