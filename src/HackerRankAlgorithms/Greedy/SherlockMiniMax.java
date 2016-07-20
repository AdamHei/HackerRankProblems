package HackerRankAlgorithms.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SherlockMiniMax {

    private static int minimum;
    private static int minMax;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.readLine();

        int[] arr = toIntArray(br.readLine().split(" "));
        int[] range = toIntArray(br.readLine().split(" "));

        Arrays.sort(arr);

        minimum = Integer.MAX_VALUE;
        minMax = Integer.MIN_VALUE;

        if (range[0] < arr[0]){
            minimum = range[0];
            minMax = arr[0] - range[0];
        }
        if (range[1] > arr[arr.length - 1]){
            if (range[1] - arr[arr.length - 1] > minMax){
                minMax = range[1] - arr[arr.length - 1];
                minimum = range[1];
            }
        }

        for (int i = 0; i < arr.length - 1; i++){
            int left = arr[i];
            int right = arr[i + 1];

            if (overlaps(left, right, range)) {
                int middle = (left + right) / 2;
                if (middle >= range[0] && range[1] >= middle){
                    updateMin(left, right, middle);
                }
                else if (middle < range[0]){
                    updateMin(left, right, range[0]);
                }
                else {
                    updateMin(left, right, range[1]);
                }
            }
        }

        System.out.println(minimum);
    }

    private static void updateMin(int left, int right, int num){
        int tempMinMax = Math.min(num - left, right - num);

        if (tempMinMax > minMax){
            minimum = num;
            minMax = tempMinMax;
        }
        else if (tempMinMax == minMax){
            if (num < minimum){
                minimum = num;
            }
        }
    }

    private static boolean overlaps(int left, int right, int[] range){
        return left <= range[1] && right >= range[0];
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }
}

