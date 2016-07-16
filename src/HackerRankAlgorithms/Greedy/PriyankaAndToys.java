package HackerRankAlgorithms.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Adam on 7/16/2016.
 */
public class PriyankaAndToys {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

        int[] weights = toIntArray(br.readLine().split(" "));
        Arrays.sort(weights);

        int cost = 0;
        for (int i = 0; i < weights.length; i++){
            int range = weights[i] + 4;
            cost++;
            while (i < weights.length && weights[i] <= range){
                i++;
            }
            i--;
        }

        System.out.println(cost);
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }
}
