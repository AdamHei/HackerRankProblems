package Contests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Adam on 5/23/2016.
 */
public class WeekOfCodeMonday1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = toIntArray(br.readLine().split(" "))[1];
        int[] arr = toIntArray(br.readLine().split(" "));

        parse(k, arr);
    }

    private static void parse(int k, int[] arr){
        int counter = 0;
        for (int i = 0; i < arr.length - 1; i++){
            for (int j = i + 1; j < arr.length; j++){
                if ((arr[i] + arr[j]) % k == 0){
                    counter++;
                }
            }
        }
        System.out.println(counter);
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }
}
