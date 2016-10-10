package HackerRankAlgorithms.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Adam on 10/10/2016.
 */
public class BeautifulTriplets {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int d = toIntArray(br.readLine().split(" "))[1];
        int[] arr = toIntArray(br.readLine().split(" "));

        Map<Integer, Set<Integer>> numToIndicies = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            Set<Integer> indices = numToIndicies.containsKey(arr[i]) ? numToIndicies.get(arr[i]) : new HashSet<>();
            indices.add(i);
            numToIndicies.put(arr[i], indices);
        }

        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            int j = d + arr[i];
            int k = 2 * d + arr[i];
            if (numToIndicies.containsKey(j) && numToIndicies.containsKey(k)){
                for (int js: numToIndicies.get(j)){
                    for (int ks: numToIndicies.get(k)){
                        if (js > i && ks > js) count++;
                    }
                }
            }
        }

        System.out.println(count);
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }
}
