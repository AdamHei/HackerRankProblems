package HackerRankAlgorithms.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Adam on 7/16/2016.
 */
public class JimAndTheOrders {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine().trim());

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= cases; i++){
            int[] times = toIntArray(br.readLine().split(" "));
            int sum = times[0] + times[1];
            if (!map.containsKey(sum)){
                List<Integer> orders = new ArrayList<>();
                orders.add(i);
                map.put(sum, orders);
            }
            else{
                List<Integer> orders = map.get(sum);
                orders.add(i);
                map.put(sum, orders);
            }
        }

        List<Integer> times = new ArrayList<>(map.keySet());
        Collections.sort(times);

        for (int key: times){
            List<Integer> orderNums = map.get(key);
            Collections.sort(orderNums);
            for (int order: orderNums){
                System.out.print(order + " ");
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
