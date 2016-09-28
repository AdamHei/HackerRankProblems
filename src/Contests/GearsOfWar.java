package Contests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Easiest dang HR Challenge problem
 */
public class GearsOfWar {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < cases; i++) {
            System.out.println(Integer.parseInt(br.readLine()) % 2 == 0 ? "Yes" : "No");
        }
    }
}
