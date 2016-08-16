package HackerRankAlgorithms.Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Adam on 8/16/2016.
 */
public class StringConstruction {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine().trim());

        for (int i = 1; i <= cases; i++){
            String s = br.readLine();
            int count = 0;
            boolean[] visited = new boolean[200];
            for (char c: s.toCharArray()){
                if (!visited[c]){
                    count++;
                    visited[c] = true;
                }
            }
            System.out.println(count);
        }
    }
}
