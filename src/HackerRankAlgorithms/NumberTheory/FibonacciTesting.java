package HackerRankAlgorithms.NumberTheory;

import java.math.BigInteger;

/**
 * Created by Adam on 5/26/2016.
 */
public class FibonacciTesting {

    private static BigInteger zero = new BigInteger("0");
    private static BigInteger one = new BigInteger("1");
    private static BigInteger two = new BigInteger("2");
    private static BigInteger three = new BigInteger("3");

    private static BigInteger[][] factor = {{one, one},{one, zero}};

    public static void main(String[] args){
        long start = System.currentTimeMillis();
        System.out.println(fib(new BigInteger("500")));
        System.out.println("That took " + (System.currentTimeMillis() - start) + " millisecond(s)!");
    }

    private static BigInteger fib(BigInteger n){
        BigInteger[][] arr = {{one, one},{one, zero}};

        if (n.equals(zero)) return zero;
        power(arr, n.subtract(one));
        return arr[0][0];
    }

    private static void power(BigInteger[][] arr, BigInteger n){
        if (n.equals(zero) || n.equals(one)) return;

        power(arr, n.divide(two));
        multiply(arr, arr);

        if (!n.mod(two).equals(zero)){
            multiply(arr, factor);
        }
    }

    private static void multiply(BigInteger[][] arr, BigInteger[][] factor){
        BigInteger x = arr[0][0].multiply(factor[0][0]).add((arr[0][1].multiply(factor[1][0])));
        BigInteger y = arr[0][0].multiply(factor[0][1]).add((arr[0][1].multiply(factor[1][1])));
        BigInteger z = arr[1][0].multiply(factor[0][0]).add((arr[1][1].multiply(factor[1][0])));
        BigInteger w = arr[1][0].multiply(factor[0][1]).add((arr[1][1].multiply(factor[1][1])));

        arr[0][0] = x;
        arr[0][1] = y;
        arr[1][0] = z;
        arr[1][1] = w;
    }
}
