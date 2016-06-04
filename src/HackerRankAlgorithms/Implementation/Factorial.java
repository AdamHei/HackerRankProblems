package HackerRankAlgorithms.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by Adam on 5/15/2016.
 */
public class Factorial {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        BigInteger big = new BigInteger("1");
        for (int i = 1; i <= n; i += 1){
            big = big.multiply(new BigInteger(i + ""));
        }
        System.out.println(big);
    }
}
