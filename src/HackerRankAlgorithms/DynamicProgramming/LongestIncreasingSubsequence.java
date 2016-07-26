package HackerRankAlgorithms.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Adam on 7/25/2016.
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine().trim());

        int[] arr = new int[cases];
        for (int i = 1; i <= cases; i++){
            arr[i - 1] = Integer.parseInt(br.readLine());
        }

        fastestSolution(arr);
    }

    private static void fastestSolution(int[] arr){
        int[] tails = new int[arr.length];
        int length = 1;
        tails[0] = arr[0];

        for (int i = 1; i < arr.length; i++){
            if (arr[i] < tails[0]){
                //New smallest
                tails[0] = arr[i];
            }
            else if (arr[i] > tails[length - 1]){
                //extend current longest
                tails[length++] = arr[i];
            }
            else{
                int ceilingIndex = ceilingIndex(tails, -1, length - 1, arr[i]);
                tails[ceilingIndex] = arr[i];
            }
        }
        System.out.println(length);
    }

    private static int ceilingIndex(int[] arr, int left, int right, int key){
        while (right - left > 1){
            int m = left + (right - left)/2;
            if (arr[m] >= key){
                right = m;
            }
            else{
                left = m;
            }
        }
        return right;
    }

    private static void fastSolution(int[] arr){
        int[] lis = new int[arr.length];
        Arrays.fill(lis, 1);

        for (int i = 1; i < lis.length; i++){
            for (int j = 0; j < i; j++){
                if (arr[j] < arr[i] && lis[i] < lis[j] + 1){
                    lis[i] = lis[j] + 1;
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i: lis){
            max = Math.max(max, i);
        }
        System.out.println(max);
    }

    private static void slowSolution(int[] arr){
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] liss = (ArrayList<Integer>[])new ArrayList[arr.length];
        for (int i = 0; i < liss.length; i++){
            liss[i] = new ArrayList<>();
        }

        liss[0].add(arr[0]);

        for (int i = 1; i < arr.length; i++){
            for (int j = 0; j < i; j++){
                if (arr[j] < arr[i] && liss[i].size() < liss[j].size() + 1){
                    liss[i] = new ArrayList<>(liss[j]);
                }
            }
            liss[i].add(arr[i]);
        }

        int maxSize = Integer.MIN_VALUE;
        for (ArrayList<Integer> list: liss){
            maxSize = Math.max(maxSize, list.size());
        }

        System.out.println(maxSize);
    }

    private static void print(ArrayList<Integer> arr){
        for (int i: arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
