package HackerRankAlgorithms.BitManipulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Created by Adam on 5/19/2016.
 */
public class LonelyInteger {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

        int[] arr = toIntArray(br.readLine().split(" "));
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i: arr){
            if (map.get(i) == null){
                map.put(i, 1);
            }
            else{
                map.put(i, map.get(i) + 1);
            }
        }

        map.keySet().stream().filter(i -> map.get(i) == 1).forEach(i -> {
            System.out.println(i);
            System.exit(0);
        });
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }
}
