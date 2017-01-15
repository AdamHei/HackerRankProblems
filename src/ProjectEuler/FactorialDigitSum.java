package ProjectEuler;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * Created by Adam on 1/14/2017.
 */
public class FactorialDigitSum {
    public static void main(String[] args) {
        BigInteger big = new BigInteger("1");
        for (int i = 2; i <= 100; i++) {
            big = big.multiply(new BigInteger(Integer.toString(i)));
        }

        int sum = 0;
        for (char c : big.toString().toCharArray()) {
            sum += Integer.parseInt(c + "");
        }

        System.out.println(sum);
    }
}
