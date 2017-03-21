package Contests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class SeparateTheNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cases = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < cases; i++) {
            String number = br.readLine().trim();

            boolean wasSeparable = false;
            for (int j = 1; j <= number.length() / 2; j++) {
                BigInteger potentialStart = new BigInteger(number.substring(0, j));

                boolean isSeparable = beautifulFinderRec(potentialStart, number.substring(j));

                if (isSeparable) {
                    System.out.println("YES " + potentialStart.toString());
                    wasSeparable = true;
                    break;
                }
            }

            if (!wasSeparable) {
                System.out.println("NO");
            }
        }
    }

    private static boolean beautifulFinderRec(BigInteger term, String tail){
        if (tail.length() == 0) {
            return true;
        }
        if (tail.charAt(0) == '0') {
            return false;
        }

        BigInteger nextInt = term.add(BigInteger.ONE);
        int length = (nextInt + "").length();

        if (tail.length() < length) {
            return false;
        }

        BigInteger compareNext = new BigInteger(tail.substring(0, length));

        if (!nextInt.equals(compareNext)) {
            return false;
        }

        return beautifulFinderRec(nextInt, tail.substring(length));
    }
}
