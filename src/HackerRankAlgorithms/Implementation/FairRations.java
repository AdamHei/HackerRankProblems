package HackerRankAlgorithms.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Adam on 8/30/2016.
 */
public class FairRations {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        br.readLine();

        for (int i = 0; i < 50; i++){
            System.out.println(fibonacci(i));
        }
    }

    private static int fibonacci(int n){
        if (n == 1 || n == 0){
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }

}
