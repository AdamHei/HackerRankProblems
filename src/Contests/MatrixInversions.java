package Contests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Adam on 8/6/2016.
 */
public class MatrixInversions {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++){
            matrix[i] = toIntArray(br.readLine().split(" "));
        }

        int count = 0;
        for (int row = 0; row < matrix.length; row++){
            for (int col = 0; col < matrix[0].length; col++){
                int entry = matrix[row][col];
                for (int subRow = row; subRow < matrix.length; subRow++){
                    for (int subCol = col; subCol < matrix[0].length; subCol++){
                        if (entry > matrix[subRow][subCol]){
                            count++;
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }
}
