package HackerRankAlgorithms.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Adam on 5/17/2016.
 */
public class CavityMap {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n =Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        int[] lines = new int[n];

        for (int i = 1; i <= n; i++){
            lines[i - 1] = Integer.parseInt(br.readLine());
        }

        for (int row = 0; row < n; row++){
            for (int col = 0; col < n; col++){
                int temp = lines[row];
                for (int k = 1; k < n - col; k++){
                    temp /= 10;
                }
                temp %= 10;
                map[row][col] = temp;
            }
        }

        String[][] newMap = new String[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                newMap[i][j] = map[i][j] + "";
            }
        }

        for (int i = 1; i < n - 1; i++){
            for (int j = 1; j < n - 1; j++){
                int up = map[i - 1][j];
                int left = map[i][j - 1];
                int right = map[i][j + 1];
                int bottom = map[i + 1][j];
                int cav = map[i][j];
                if (up < cav && left < cav && right < cav && bottom < cav){
                    newMap[i][j] = "X";
                }
            }
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                System.out.print(newMap[i][j]);
            }
            System.out.println();
        }
    }
}
