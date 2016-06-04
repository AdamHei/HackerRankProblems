package Contests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Adam on 5/17/2016.
 */
public class HackMay2016 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

        int[] arr = toIntArray(br.readLine().split(" "));
        if (arr.length < 3) {
            System.out.println("-1");
            System.exit(0);
        }
        Arrays.sort(arr);

        for (int j = arr.length -1; j >= 2; j--){
            for (int k = j - 1; k >= 1; k--){
                for (int l = k - 1; l >= 0; l--){
                    int a = arr[j];
                    int b = arr[k];
                    int c = arr[l];
                    if (a + c > b && a + b > c && c + b > a){
                        System.out.println(c + " " + b + " " + a);
                        System.exit(0);
                    }
                }
            }
        }
        System.out.println("-1");
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }
}
