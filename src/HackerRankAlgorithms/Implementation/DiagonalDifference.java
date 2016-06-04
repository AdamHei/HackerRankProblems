package HackerRankAlgorithms.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Adam on 5/30/2016.
 */
public class DiagonalDifference {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++){
            arr[i] = toIntArray(br.readLine().split(" "));
        }

        int leftToRight = 0;
        int rightToLeft = 0;
        for (int i = 0; i < n; i++){
            leftToRight += arr[i][i];
            rightToLeft += arr[i][n-i-1];
        }
        System.out.println(Math.abs(leftToRight - rightToLeft));
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }
}
