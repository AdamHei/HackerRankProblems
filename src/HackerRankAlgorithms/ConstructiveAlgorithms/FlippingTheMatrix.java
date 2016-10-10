package HackerRankAlgorithms.ConstructiveAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;

/**
 * Created by Adam on 10/10/2016.
 */
public class FlippingTheMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine().trim());

        for (int i = 1; i <= cases; i++){
            int n = Integer.parseInt(br.readLine());
            int[][] matrix = new int[2*n][2*n];
            for (int j = 0; j < 2 * n; j++) {
                matrix[j] = toIntArray(br.readLine().split(" "));
            }
            System.out.println(flipMatrix(n, matrix));
        }
    }

    private static int flipMatrix(int n, int[][] matrix){
        int sum = 0;
        int twoN = n * 2 - 1;
        for (int i = 0; i <= 2 * n; i++) {
            for (int j = 0; j <= 2 * n; j++) {
                int max = Math.max(matrix[i][j], matrix[twoN - i][j]);
                max = Math.max(max, matrix[i][twoN - j]);
                max = Math.max(max, matrix[twoN - i][twoN - j]);
                sum += max;
            }
        }
        return sum;
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }
}
