package HackerRankAlgorithms.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Adam on 9/19/2016.
 */
public class Knapsack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        int[] arr = {3,4,4,4,8};
//        int k = 9;
//        System.out.println(unboundedKnapsack(arr, k));

        int cases = Integer.parseInt(br.readLine().trim());

        for (int i = 1; i <= cases; i++){
            int k = toIntArray(br.readLine().split(" "))[1];
            int[] arr = toIntArray(br.readLine().split(" "));
            System.out.println(unboundedKnapsack(arr, k));
        }
    }

    private static int unboundedKnapsack(int[] arr, int k){
        int[] knapsacks = new int[k + 1];
        knapsacks[0] = 0;
        for (int j = 1; j < knapsacks.length; j++){
            int max = knapsacks[j - 1];
            for (int weight : arr) {
                if (j - weight >= 0) {
                    max = Math.max(knapsacks[j - weight] + weight, max);
                }
            }
            knapsacks[j] = max;
        }

        return knapsacks[k];
    }

    private static int maximalSum(int[] arr, int k){
        int[][] table = new int[arr.length + 1][k + 1];

        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= k; j++) {
                if (arr[i - 1] > j || j - arr[i - 1] < 0){
                    table[i][j] = table[i - 1][j];
                }
                else {
                    table[i][j] = Math.max(
                            table[i - 1][j],
                            table[i - 1][j - arr[i - 1]] + arr[i - 1]
                    );
                }
            }
        }

//        for (int[] row: table){
//            for (int i: row){
//                System.out.print(i + " ");
//            }
//            System.out.println();
//        }

        return table[arr.length][k];
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }
}
