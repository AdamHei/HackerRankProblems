package HackerRankAlgorithms.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by Adam on 5/30/2016.
 */
public class RedJohnIsBack {

    private static HashMap<Long, Long> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine().trim());

        for (int i = 1; i <= cases; i++){
            int n = Integer.parseInt(br.readLine().trim());
//            System.out.println(i + ": " + countCombos(n));
            findPrimes(n);
        }
    }

    private static void findPrimes(int n){
        long combos = countCombos(n);
        int count = 0;
        for (long i = 1; i <= combos; i++){
            if (isPrime(i)) count++;
        }
        System.out.println(count);
    }

    private static long countCombos(long n){
        if (map.get(n) != null)
            return map.get(n);
        if (n == 1 || n == 2 || n == 3)
            return 1;
        if (n == 4)
            return 2;
        else
//            return countCombos(n - 1) + countCombos(n - 4);
            map.put(n, countCombos(n - 1) + countCombos(n - 4));
            return map.get(n);
    }

//    private static long countCombos(int n){
//        long combos = 0;
//        for (int i = 1; i <= n / 4; i++){
//            combos += (n - 4 * i + 1);
//        }
//        combos++;
//        return combos;
//    }

    private static boolean isPrime(long num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i += 2)
            if (num % i == 0) return false;
        return true;
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }
}
