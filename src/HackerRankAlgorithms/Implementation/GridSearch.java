package HackerRankAlgorithms.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Adam on 5/28/2016.
 */
public class GridSearch {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine().trim());

        for (int i = 1; i <= cases; i++){
            int[] rowAndCol = toIntArray(br.readLine().split(" "));
            int[][] original = new int[rowAndCol[0]][rowAndCol[1]];
            for (int j = 0; j < rowAndCol[0]; j++){
                original[j] = newToIntArray(br.readLine());
            }
            int[] toFindProps = toIntArray(br.readLine().split(" "));
            int[][] toFind = new int[toFindProps[0]][toFindProps[1]];
            for (int k = 0; k < toFindProps[0]; k++){
                toFind[k] = newToIntArray(br.readLine());
            }

            findExistence(rowAndCol, original, toFindProps, toFind);
        }
    }

    private static void findExistence(int[] rowAndCol, int[][] original, int[] toFindProps, int[][] toFind){
        for (int row = 0; row <= rowAndCol[0] - toFindProps[0]; row++){
            for (int col = 0; col <= rowAndCol[1] - toFindProps[1]; col++){
                if (original[row][col] == toFind[0][0]){
                    if (findFull(row, col, original, toFind)){
                        System.out.println("YES");
                        return;
                    }
                }
            }
        }
        System.out.println("NO");
    }

    private static boolean findFull(int row, int col, int[][] original, int[][] toFind){
        int tempRow = row;
        int tempCol = col;

        for (int[] aToFind : toFind) {
            for (int j = 0; j < toFind[0].length; j++) {
                if (original[tempRow][tempCol] != aToFind[j]) {
                    return false;
                }
                tempCol++;
            }
            tempCol = col;
            tempRow++;
        }
        return true;
    }

    private static int[] newToIntArray(String arr){
        int[] toReturn = new int[arr.length()];
        for (int i = 0; i < arr.length(); i++){
            toReturn[i] = Integer.parseInt(arr.charAt(i) + "");
        }
        return toReturn;
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }
}
