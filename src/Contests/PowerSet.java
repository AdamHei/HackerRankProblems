package Contests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adam on 6/11/2016.
 */
public class PowerSet {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        int[] set = toIntArray(br.readLine().split(" "));
        BigInteger[] arr = new BigInteger[set.length];
        for (int i = 0; i < set.length; i++){
            arr[i] = new BigInteger(Integer.toString(set[i]));
        }

        BigInteger sum = BigInteger.ZERO;
        List<BigInteger> products = subsetProducts(arr);
        for (BigInteger big: products){
            sum = sum.add(big);
        }
        BigInteger modulo = new BigInteger("1000000000");
        modulo = modulo.add(new BigInteger("7"));
        System.out.println(sum.mod(modulo));
    }

    private static List<BigInteger> subsetProducts(BigInteger[] set){
        int len = set.length;
        List<BigInteger> products = new ArrayList<>();

        for (int i = 0; i < (1<<len); i++){
            BigInteger product = BigInteger.ONE;
            long size = 0;
            for (int j = 0; j < len; j++){
                if ((i & (1 << j)) > 0){
                    product = product.multiply(set[j]);
                    size++;
                }
            }
            products.add(product.multiply(new BigInteger(Long.toString(size))));
        }
        return products;
    }

    private static void printSubsets(int[] set){
        int n = set.length;

        for (int i = 0; i < (1<<n); i++){
            System.out.print("{ ");

            for (int j = 0; j < n; j++){
                if ((i & (1 << j)) > 0){
                    System.out.print(set[j] + " ");
                }
            }
            System.out.println("}");
        }
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }
}
