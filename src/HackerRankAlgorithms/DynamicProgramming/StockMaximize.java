package HackerRankAlgorithms.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Adam on 5/30/2016.
 */
public class StockMaximize {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine().trim());

        for (int i = 1; i <= cases; i++){
            br.readLine();
            int[] arr = toIntArray(br.readLine().split(" "));
            maximize(arr);
        }
    }

    private static void maximize(int[] pricePerDay){
        long credits = 0;
        long shareCount = 0;
        long debits = 0;
        for (int i = 0; i < pricePerDay.length; i++){
            int maxIndex = findMaxIndex(pricePerDay, i, pricePerDay.length - 1);
            if (i != maxIndex){
                while (i < maxIndex){
                    debits += pricePerDay[i];
                    shareCount++;
                    i++;
                }
                credits += (shareCount * pricePerDay[i]);
                shareCount = 0;
            }
        }
        System.out.println(credits - debits);
    }

    private static int findMaxIndex(int[] arr, int i, int j){
        int max = Integer.MIN_VALUE;
        int index = i;
        for (int pointer = i; pointer <= j; pointer++){
            if (arr[pointer] > max){
                max = arr[pointer];
                index = pointer;
            }
        }
        return index;
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }
}
