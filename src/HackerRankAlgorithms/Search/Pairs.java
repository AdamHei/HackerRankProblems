package HackerRankAlgorithms.Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Adam on 5/27/2016.
 */
public class Pairs {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = toIntArray(br.readLine().split(" "))[1];
        int[] arr = toIntArray(br.readLine().split(" "));

        findPairs(k, arr);
    }

    private static void findPairs(int k, int[] arr){
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for (int i: arr) set.add(i - k);
        for (int i: arr) {
            if (set.contains(i)) count++;
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
