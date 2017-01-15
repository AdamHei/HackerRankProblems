package ProjectEuler;

import java.util.Arrays;

/**
 * Created by Adam on 1/14/2017.
 */
public class LatticePaths {
    public static void main(String[] args) {
        long[][] table = new long[21][21];
        Arrays.fill(table[0], 1);
        for (int i = 0; i < 21; i++) {
            table[i][0] = 1;
        }
        table[0][0] = 0;

        for (int i = 1; i < 21; i++) {
            for (int j = 1; j < 21; j++) {
                table[i][j] = table[i - 1][j] + table[i][j - 1];
            }
        }

        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 21; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println(table[20][20]);
    }
}
