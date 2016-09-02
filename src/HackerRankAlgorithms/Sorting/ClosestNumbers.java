package HackerRankAlgorithms.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by Adam on 9/2/2016.
 */
public class ClosestNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine().trim());

        int[] arr = toIntArray(br.readLine().split(" "));
        Arrays.sort(arr);
        List<Entry> list = new ArrayList<>();

        int minDifference = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++){
            int left = arr[i];
            int right = arr[i + 1];
            if (right - left == minDifference){
                list.add(new Entry(left, right));
            }
            else if (right - left < minDifference){
                minDifference = right - left;
                list.clear();
                list.add(new Entry(left, right));
            }
        }

        for (Entry entry: list){
            System.out.print(entry.getKey() + " " + entry.getValue() + " ");
        }
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }

    private static class Entry implements Map.Entry {
        int key, val;
        Entry(int key, int val){
            this.key = key;
            this.val = val;
        }

        @Override
        public Object getKey() {
            return key;
        }

        @Override
        public Object getValue() {
            return val;
        }

        @Override
        public Object setValue(Object value) {
            return null;
        }
    }
}
