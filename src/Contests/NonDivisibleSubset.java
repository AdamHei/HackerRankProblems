package Contests;

import java.io.IOException;

public class NonDivisibleSubset {
    public static void main(String[] args) throws IOException {
        System.out.println(subSetSumDynamic(new int[]{10, 12, 6, 4, 1, 3, 15, 9}, 34));

    }

    private static boolean subSetSumDynamic(int[] arr, int sum){
        boolean[][] solution = new boolean[arr.length + 1][sum + 1];

        for (int i = 1; i <= sum; i++){
            solution[0][i] = false;
        }

        for (int i = 0; i <= arr.length; i++){
            solution[i][0] = true;
        }

        for (int i = 1; i <= arr.length; i++){
            for (int j = 1; j <= sum; j++){
                solution[i][j] = solution[i - 1][j];

                if (!solution[i][j] && j >= arr[i - 1]){
                    solution[i][j] = solution[i][j] || solution[i - 1][j - arr[i - 1]];
                }
            }
        }

        for (int i = 0; i < solution.length; i++){
            for (int j = 0; j < solution[0].length; j++){
                System.out.print(solution[i][j] ? "Y " : "N ");
            }
            System.out.println();
        }

        return solution[arr.length][sum];
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }
}
