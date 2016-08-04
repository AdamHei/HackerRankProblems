package HackerRankAlgorithms.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Adam on 7/31/2016.
 */
public class MaxMin {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine().trim());
        int k = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= cases; i++){
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list);

        int maxMin = Integer.MAX_VALUE;
        for (int i = 0; i < list.size() - k + 1; i++){
            int j = i + k - 1;
            int temp = list.get(j) - list.get(i);
            maxMin = Math.min(temp, maxMin);
        }

        System.out.println(maxMin);
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }
}
