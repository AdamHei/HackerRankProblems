package HackerRankAlgorithms.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Adam on 5/30/2016.
 */
public class FullCountingSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine().trim());

        Map<Integer, ArrayList<String>> map = new HashMap<>();
        ArrayList<String> firstHalf = new ArrayList<>();
        for (int i = 1; i <= number; i++){
            String[] arr = br.readLine().split(" ");
            int num = Integer.parseInt(arr[0]);
            String s = arr[1];
            if (i < number / 2){
                firstHalf.add(s);
            }
            ArrayList<String> list;
            if (map.get(num) != null){
                list = map.get(num);
                list.add(s);
                map.put(num, list);
            }
            else{
                list = new ArrayList<>();
                list.add(s);
                map.put(num, list);
            }
        }

        List<Integer> keys = new ArrayList<>();
        keys.addAll(map.keySet());
        Collections.sort(keys);
        List<String> hugeList = new ArrayList<>();
        for (int key: keys){
            hugeList.addAll(map.get(key));
        }

        for (int i = 0; i < number; i++){
            if (firstHalf.contains(hugeList.get(i))){
                System.out.print("- ");
            }
            else{
                System.out.print(hugeList.get(i) + " ");
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
