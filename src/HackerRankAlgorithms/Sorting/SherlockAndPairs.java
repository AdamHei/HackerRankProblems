package HackerRankAlgorithms.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Created by Adam on 5/16/2016.
 */
public class SherlockAndPairs {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());

        for (int j = 1; j <= cases; j += 1){
            br.readLine();
            int[] arr = toIntArray(br.readLine().split(" "));

            HashMap<Integer, Integer> dupes = new HashMap<>();

            for (int i: arr){
                if (dupes.get(i) != null){
                    dupes.put(i, dupes.get(i) + 1);
                }
                else{
                    dupes.put(i, 1);
                }
            }
            boolean printed = false;
            long count = 0;
            for (int i: dupes.keySet()){
                if (dupes.get(i) > 1){
                    count += binomial(dupes.get(i), 2) * 2;
                    printed = true;
                }
            }
            if (!printed){
                System.out.println(0);
            }
            else {
                System.out.println(count);
            }
        }
    }

    private static long binomial(int n, int k)
    {
        if (k>n-k)
            k=n-k;

        long b=1;
        for (int i=1, m=n; i<=k; i++, m--)
            b=b*m/i;
        return b;
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }
}
