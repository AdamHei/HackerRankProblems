package Contests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Adam on 6/28/2016.
 */
public class LazySorting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

        long[] arr = toLongArray(br.readLine().split(" "));
//        long[] arr = {1,2,3};
        Set<Long> set = new HashSet<>();
        for (long i: arr){
            set.add(i);
        }
        int num = (arr.length - set.size()) * 2;
        BigDecimal numDupes = new BigDecimal(Integer.toString(num));
        long length = arr.length;
        BigDecimal distinctPerms = factorial(length).divide(numDupes.equals(BigDecimal.ZERO) ? BigDecimal.ONE : numDupes, 100, RoundingMode.CEILING);
        System.out.println(distinctPerms.setScale(6, BigDecimal.ROUND_CEILING));
//        sumMe(distinctPerms);
    }
    
    private static void sumMe(BigDecimal distinctPerms){
        BigDecimal sum = BigDecimal.ZERO;
        for (int i = 1; i < 100; i++){
            BigDecimal pInverse = BigDecimal.ONE.divide(distinctPerms, 100, BigDecimal.ROUND_CEILING);

            BigDecimal product = BigDecimal.ONE;
            product = product.multiply(new BigDecimal(Integer.toString(i)));

            BigDecimal factor = BigDecimal.ONE.subtract(pInverse).pow(i - 1);
            product = product.multiply(factor);
            product = product.multiply(pInverse);

//            System.out.println(product.toString());
            sum = sum.add(product);
        }
        sum = sum.setScale(6, BigDecimal.ROUND_CEILING);
        boolean flag = true;
        for (int i = 2; i < 8; i++){
            if (sum.toString().charAt(i) != '9'){
                flag = false;
                i = 8;
            }
        }
        String s;
        if (flag){
            sum = sum.setScale(0, BigDecimal.ROUND_CEILING);
            s = sum.toString();
            s += ".000000";
        }
        else{
            s = sum.toString();
        }
        System.out.println(s);
    }
    
    private static BigDecimal factorial(long l){
        BigDecimal big = new BigDecimal("1");
        for (long i = 1; i <= l; i += 1){
            big = big.multiply(new BigDecimal(Long.toString(i)));
        }
        return big;
    }

    private static long[] toLongArray(String[] arr){
        long[] toReturn = new long[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Long.parseLong(arr[i]);
        }
        return toReturn;
    }
}
