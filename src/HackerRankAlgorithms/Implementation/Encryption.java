package HackerRankAlgorithms.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Adam on 5/28/2016.
 */
public class Encryption {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] string = br.readLine().trim().toCharArray();

        int floor = (int) Math.sqrt(string.length);
        int ceiling = Math.sqrt(string.length) % 1 > 0 ? ((int) Math.sqrt(string.length)) + 1 : floor;

        if (floor * ceiling < string.length) floor++;


        char[][] toFill = new char[floor][ceiling];

        int row = 0;
        int col = 0;
        for (char c: string){
            toFill[row][col] = c;
            col++;
            if (col == ceiling){
                col %= ceiling;
                row++;
            }
        }

        StringBuilder s = new StringBuilder();
        for (int j = 0; j < ceiling; j++){
            for (int i = 0; i < floor; i++){
                s.append(toFill[i][j]);
            }
            if (j < ceiling - 1) s.append(" ");
        }
        System.out.println(s.toString());
    }
}
