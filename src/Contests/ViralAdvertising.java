package Contests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Adam on 10/15/2016.
 */
public class ViralAdvertising {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        System.out.println(adViewers(n));

    }

    private static int adViewers(int n){
        int people = 5;

        int total = 2;

        for (int i = 1; i < n; i++) {
            people = (people / 2) * 3;
            total += people / 2;
        }

        return total;
    }
}
