package HackerRankAlgorithms.GraphTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Adam on 7/12/2016.
 */
public class GridChallenge {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine().trim());

        for (int i = 1; i <= cases; i++){
            int n = Integer.parseInt(br.readLine());
            char[][] arr = new char[n][n];
            for (int j = 0; j < n; j++){
                char[] row = br.readLine().toCharArray();
                Arrays.sort(row);
                arr[j] = row;
            }

            boolean notSorted = false;
            for (int col = 0; col < arr.length; col++){
                for (int row = 1; row < arr.length; row++){
                    if (arr[row - 1][col] > arr[row][col]){
                        notSorted = true;
                    }
                }
            }

            if (notSorted){
                System.out.println("NO");
            }
            else{
                System.out.println("YES");
            }
        }
    }
}
