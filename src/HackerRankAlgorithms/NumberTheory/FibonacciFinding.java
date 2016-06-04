package HackerRankAlgorithms.NumberTheory;

/**
 * Created by Adam on 5/26/2016.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;

/**
 * Created by Adam on 5/11/2016.
 */
public class FibonacciFinding {

    private static HashMap<BigInteger, BigInteger> map;

    private static BigInteger zero = new BigInteger("0");
    private static BigInteger one = new BigInteger("1");
    private static BigInteger two = new BigInteger("2");
    private static BigInteger billionAndSeven = new BigInteger("1000000007");

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cases = Integer.parseInt(br.readLine().trim());

        for (int i = 1; i <= cases; i++){
            String[] arr = br.readLine().split(" ");
            BigInteger a = new BigInteger(arr[0]);
            BigInteger b = new BigInteger(arr[1]);
            int n = Integer.parseInt(arr[2]);

            map = new HashMap<>();

            System.out.println(newFibFinding(a, b, n).mod(billionAndSeven));
        }
    }

    private static BigInteger newFibFinding(BigInteger a, BigInteger b, int n){
        if (n == 0) return a;
        else if (n == 1) return b;

        BigInteger first = a;
        BigInteger second = b;
        BigInteger third = a.add(b);
        for (int i = 2; i <= n; i++){
            BigInteger temp = new BigInteger(third.toString());
            third = first.add(second);
            first = second;
            second = temp;
        }

        return third;
    }


    private static BigInteger fibFinding(BigInteger a, BigInteger b, BigInteger n){
        if (map.get(n) != null){
            return map.get(n);
        }
        else if (n.equals(zero)){
            map.put(zero, a);
            return a;
        }
        else if (n.equals(one)){
            map.put(one, b);
            return b;
        }
//        else if (n.equals(b.add(a))){
//            map.put(n, b.add(a));
//            return map.get(n);
//        }
        else{
            BigInteger d = fibFinding(a, b, n.subtract(new BigInteger("2")));
            BigInteger c = fibFinding(a, b, n.subtract(new BigInteger("1")));
            return c.add(d);
        }
    }
}
