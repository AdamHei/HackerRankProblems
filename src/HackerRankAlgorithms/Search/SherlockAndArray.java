package HackerRankAlgorithms.Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Adam on 5/16/2016.
 */
public class SherlockAndArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());

        for (int i = 1; i <= cases; i += 1){
            br.readLine();
            int[] arr = toIntArray(br.readLine().split(" "));
            parse(arr);
        }
    }

    private static void parse(int[] arr){
        if (arr.length == 1){
            System.out.println("YES");
            return;
        }
        if (arr.length == 2){
            System.out.println("NO");
            return;
        }
        int i = 0;
        int j = arr.length - 1;
        int leftSum = 0;
        int rightSum = 0;
        while (i <= j){
            if (leftSum == rightSum && i == j){
                System.out.println("YES");
                return;
            }
            if (leftSum < rightSum){
                leftSum += arr[i];
                i++;
            }
            else if (rightSum < leftSum){
                rightSum += arr[j];
                j--;
            }
            else{
                leftSum += arr[i];
                rightSum += arr[j];
                i++;
                j--;
            }
        }
        System.out.println("NO");
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }
}
