package HackerRankAlgorithms.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Adam on 5/17/2016.
 */
public class Candies {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine().trim());
        }

        if (n == 1) {
            System.out.println(1);
            System.exit(0);
        }

        int[] candies = new int[n];
        Arrays.fill(candies, 0);

        //Find the indices of all local minima and initialize those candies to 1
        List<Integer> minimaIndices = new ArrayList<>();
        if (arr[1] >= arr[0]){
            minimaIndices.add(0);
        }
        if (arr[arr.length - 2] >= arr[arr.length - 1]){
            minimaIndices.add(arr.length - 1);
        }
        for (int i = 1; i < arr.length - 1; i++){
            if (arr[i - 1] > arr[i] && arr[i] <= arr[i + 1] || arr[i - 1] >= arr[i] && arr[i] < arr[i + 1]){
                minimaIndices.add(i);
            }
        }
        for (int index: minimaIndices){
            candies[index] = 1;
        }

        //For every local minimum, climb on either side, adding one to each value greater than the last
        for (int index: minimaIndices){
            int i = index;
            int j = index;
            while (i > 0 && arr[i - 1] > arr[i]){
                if (candies[i - 1] == 0){
                    candies[i - 1] = candies[i] + 1;
                }
                else if (candies[i - 1] <= candies[i] + 1){
                    candies[i - 1] += candies[i] + 1 - candies[i - 1];
                }
                i--;
            }
            while (j < arr.length - 1 && arr[j + 1] > arr[j]){
                if (candies[j + 1] == 0){
                    candies[j + 1] = candies[j] + 1;
                }
                else if (candies[j + 1] <= candies[j] + 1){
                    candies[j + 1] += candies[j] + 1 - candies[j + 1];
                }
                j++;
            }
        }

        //If one was left at 0, then we had a string of same ranks in a row, thus they all get only 1
        long sum = 0;
        for (int i: candies){
            if (i == 0){
                sum++;
            }
            else{
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
