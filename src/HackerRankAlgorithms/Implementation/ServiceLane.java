package HackerRankAlgorithms.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Adam on 5/17/2016.
 */
public class ServiceLane {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = toIntArray(br.readLine().split(" "))[1];
        int[] arr = toIntArray(br.readLine().split(" "));
        for (int i = 1; i <= cases; i++){
            int[] indices = toIntArray(br.readLine().split(" "));
            findVehicle(arr, indices[0], indices[1]);
        }
    }

    private static void findVehicle(int[] arr, int i, int j){
        int min = 3;
        for (int k = i; k <= j; k++){
            min = arr[k] < min ? arr[k] : min;
        }
        System.out.println(min);
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }
}
