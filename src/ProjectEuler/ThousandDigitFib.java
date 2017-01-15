package ProjectEuler;

import java.math.BigInteger;

/**
 * Created by Adam on 1/14/2017.
 */
public class ThousandDigitFib {
    public static void main(String[] args) {
        BigInteger prev = BigInteger.ONE, num = BigInteger.ONE;

        int index = 2;
        BigInteger temp;
        while (true) {
            index++;
            temp = new BigInteger(num.toString());
            num = num.add(prev);
            prev = new BigInteger(temp.toString());

            if (num.toString().length() >= 1000){
                break;
            }
        }

        System.out.println(index);
    }
}
