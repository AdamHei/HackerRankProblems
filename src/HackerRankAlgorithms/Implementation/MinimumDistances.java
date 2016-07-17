package HackerRankAlgorithms.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Adam on 7/17/2016.
 */
public class MinimumDistances {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

        int[] arr = toIntArray(br.readLine().split(" "));

        Map<Integer, Integer> lastIndex = new HashMap<>();
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++){
            if (lastIndex.get(arr[i]) == null){
                lastIndex.put(arr[i], i);
            }
            else{
                int last = lastIndex.get(arr[i]);
                minDistance = Math.min(minDistance, i - last);
                lastIndex.put(arr[i], i);
            }
        }

        System.out.println(minDistance == Integer.MAX_VALUE ? -1 : minDistance);
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }
}
