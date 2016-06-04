package HackerRankAlgorithms.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;

/**
 * Created by Adam on 5/11/2016.
 */
public class FibonacciModified {

    private static HashMap<BigInteger, BigInteger> map;

    private static BigInteger one = new BigInteger("1");
    private static BigInteger two = new BigInteger("2");

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        BigInteger a = new BigInteger(arr[0]);
        BigInteger b = new BigInteger(arr[1]);
        BigInteger n = new BigInteger(arr[2]);

        map = new HashMap<>();

        System.out.println(fibModified(a, b, n));
    }


    private static BigInteger fibModified(BigInteger a, BigInteger b, BigInteger n){
        if (map.get(n) != null){
            return map.get(n);
        }
        else if (n.equals(one)){
            map.put(new BigInteger("1"), a);
            return a;
        }
        else if (n.equals(two)){
            map.put(new BigInteger("2"), b);
            return b;
        }
        else if (n.equals(b.add(new BigInteger("1")))){
            map.put(n, b.multiply(b).add(a));
            return map.get(n);
        }
        else{
            BigInteger d = fibModified(a, b, n.subtract(new BigInteger("2")));
            BigInteger c = fibModified(a, b, n.subtract(new BigInteger("1")));
            return c.multiply(c).add(d);
        }
    }
}
