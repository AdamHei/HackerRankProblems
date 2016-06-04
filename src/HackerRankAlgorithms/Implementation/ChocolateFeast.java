package HackerRankAlgorithms.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Adam on 5/17/2016.
 */
public class ChocolateFeast {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());
        for (int i = 1; i <= cases; i++){
            int[] ncm = toIntArray(br.readLine().split(" "));
            parseArr(ncm);
        }
    }

    private static void parseArr(int[] arr){
        int total = arr[0] / arr[1];
        if (total >= arr[2]){
            int temp = total;
            while (temp >= arr[2]){
                temp -= arr[2];
                total++;
                temp++;
            }
        }
        System.out.println(total);
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }
}
