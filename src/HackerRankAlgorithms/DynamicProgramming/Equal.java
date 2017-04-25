package HackerRankAlgorithms.DynamicProgramming;

import org.jetbrains.annotations.Contract;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Equal {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cases = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < cases; i++) {
            br.readLine();

            int[] arr = toIntArray(br.readLine().split(" "));
            Arrays.sort(arr);

            int count = 0;
            for (int j = arr.length - 1; j > 0; j--) {

                int diff = arr[j] - arr[0];
                int tempActions = minActions(diff);

                count += tempActions;
            }

            System.out.println(count);
        }
    }

    @Contract(pure = true)
    private static int minActions(int num) {
        int count = 0;
        while (num > 0) {
            if (num >= 5) {
                count++;
                num -= 5;
            } else if (num >= 2) {
                count++;
                num -= 2;
            } else {
                count++;
                num--;
            }
        }
        return count;
    }

    private static int[] toIntArray(String[] strArr) {
        int[] arr = new int[strArr.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }
        return arr;
    }
}
