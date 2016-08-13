package Contests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Technically works, but times out with sufficiently large n
 * Find a faster way
 */
public class RemainingFactors {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long squaredN = n * n;

        int count = 0;
        for (int i = 2; i < n; i++){
            if (n % i != 0){
                if (squaredN % i == 0){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
