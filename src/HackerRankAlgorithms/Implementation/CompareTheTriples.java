package HackerRankAlgorithms.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Adam on 7/14/2016.
 */
public class CompareTheTriples {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] a = toIntArray(br.readLine().split(" "));
        int[] b = toIntArray(br.readLine().split(" "));

        int aScore = 0, bScore = 0;
        for (int i = 0; i < a.length; i++){
            if (a[i] > b[i]){
                aScore++;
            }
            else if (b[i] > a[i]){
                bScore++;
            }
        }

        System.out.println(aScore + " " + bScore);
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }
}
