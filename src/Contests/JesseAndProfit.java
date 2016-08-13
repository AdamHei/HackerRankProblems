package Contests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Adam on 8/6/2016.
 */
public class JesseAndProfit {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nandd = toIntArray(br.readLine().split(" "));
        int d = nandd[1];
        int n = nandd[0];
        int[] prices = toIntArray(br.readLine().split(" "));
        int[] queries = new int[d];
        for (int i = 0; i < d; i++){
            queries[i] = Integer.parseInt(br.readLine());
        }

        Map<Integer, List<Integer>> priceToIndices = new HashMap<>();
        for (int i = 0; i < prices.length; i++){
            int price = prices[i];
            if (priceToIndices.containsKey(price)){
                List<Integer> indices = priceToIndices.get(price);
                indices.add(i);
                priceToIndices.put(price, indices);
            }
            else{
                List<Integer> indices = new ArrayList<>();
                indices.add(i);
                priceToIndices.put(price, indices);
            }
        }

        for (int query: queries){
            Map.Entry<Integer, Integer> minEntry = new MyEntry<>(0, Integer.MAX_VALUE);
            for (int i = 0; i < prices.length; i++){
                int price = prices[i];
                int desiredPrice = query + price;
                if (priceToIndices.containsKey(desiredPrice)){
                    List<Integer> indices = priceToIndices.get(desiredPrice);
                    int smallestIndex = Integer.MAX_VALUE;
                    for (int index: indices){
                        if (index > i){
                            smallestIndex = index;
                            break;
                        }
                    }
                    if (smallestIndex != Integer.MAX_VALUE && (smallestIndex - i) < (minEntry.getValue() - minEntry.getKey())){
                        minEntry = new MyEntry<>(i, smallestIndex);
                    }
                }
            }
            if (minEntry.getValue() != Integer.MAX_VALUE){
                System.out.println((minEntry.getKey() + 1) + " " + (minEntry.getValue() + 1));
            }
            else{
                System.out.println(-1);
            }
        }

//        Map<Long, Map.Entry<Integer, Integer>> profitToIndices = new HashMap<>();
//        for (int i = 0; i < prices.length; i++){
//            for (int j = i + 1; j < prices.length; j++){
//                long profit = prices[j] - prices[i];
//                long tempLength = j - i;
//                if (profitToIndices.containsKey(profit)){
//                    Map.Entry<Integer, Integer> entry = profitToIndices.get(profit);
//                    long length = entry.getValue() - entry.getKey();
//                    if (tempLength < length){
//                        profitToIndices.put(profit, new MyEntry<>(i, j));
//                    }
//                }
//                else{
//                    profitToIndices.put(profit, new MyEntry<>(i, j));
//                }
//            }
//        }
//
//        for (long query: queries){
//            if (profitToIndices.containsKey(query)){
//                Map.Entry<Integer, Integer> entry = profitToIndices.get(query);
//                System.out.println((entry.getKey() + 1) + " " + (entry.getValue() + 1));
//            }
//            else{
//                System.out.println(-1);
//            }
//        }
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }
}

final class MyEntry<K, V> implements Map.Entry<K, V> {
    private final K key;
    private V value;

    public MyEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V value) {
        V old = this.value;
        this.value = value;
        return old;
    }
}
