package HackerRankAlgorithms.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Adam on 9/2/2016.
 */
public class CountingSort3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine().trim());

        int[] arr = new int[cases];
        for (int i = 1; i <= cases; i++){
            arr[i - 1] = Integer.parseInt(br.readLine().split(" ")[0]);
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i: arr){
            if (map.containsKey(i)){
                map.put(i, map.get(i) + 1);
            }
            else {
                map.put(i, 1);
            }
        }

        Set<Integer> nums = map.keySet();
        List<Integer> list = new ArrayList<>(nums);
        Collections.sort(list);
        int runningTotal = 0;

        for (int i = 0; i < 100; i++){
            if (list.contains(i)){
                runningTotal += map.get(list.get(i));
            }
            System.out.print(runningTotal + " ");
        }
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }

    public static void print(int[] arr){
        for (int i: arr) {
            System.out.print(i + " ");
        }
    }
}
