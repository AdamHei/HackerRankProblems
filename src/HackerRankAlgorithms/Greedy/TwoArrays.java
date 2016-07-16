package HackerRankAlgorithms.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Adam on 7/16/2016.
 */
public class TwoArrays {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine().trim());

        for (int i = 1; i <= cases; i++){
            int[] nandk = toIntArray(br.readLine().split(" "));
            int[] a = toIntArray(br.readLine().split(" "));
            int[] b = toIntArray(br.readLine().split(" "));

            Arrays.sort(a);
            Arrays.sort(b);

            boolean printed = false;
            for (int j = 0; j < a.length; j++){
                if (a[j] + b[b.length - j - 1] < nandk[1]){
                    System.out.println("NO");
                    printed = true;
                    j = a.length;
                }
            }
            if (!printed){
                System.out.println("YES");
            }
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
