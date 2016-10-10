package HackerRankAlgorithms.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Adam on 10/3/2016.
 */
public class MaxPerimeterTriangle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        int[] arr = toIntArray(br.readLine().split(" "));

        Arrays.sort(arr);
        int r = arr.length - 1;
        int c = arr.length - 2;
        int l = arr.length - 3;
        while (l >= 0 && arr[l] + arr[c] <= arr[r]){
            l--;
        }

        if (l <= 0){
            System.out.println(-1);
        }
        else {
            System.out.println(arr[l] + " " + arr[c] + " " + arr[r]);
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
