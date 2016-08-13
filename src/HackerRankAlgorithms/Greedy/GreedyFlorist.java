package HackerRankAlgorithms.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Adam on 8/4/2016.
 */
public class GreedyFlorist {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nandk = toIntArray(br.readLine().split(" "));
        int[] arr = toIntArray(br.readLine().split(" "));
        int k = nandk[1];

        Arrays.sort(arr);
        int totalCost = 0;
        int coefficient = 1;
        int counter = 0;
        for (int i = arr.length - 1; i >= 0; i--){
            totalCost += coefficient * arr[i];
            counter++;
            if (counter == k){
                coefficient++;
                counter = 0;
            }
        }

        System.out.println(totalCost);
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }
}
