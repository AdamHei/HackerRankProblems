package Contests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Adam on 6/27/2016.
 */
public class Kangaroo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double[] arr = toDoubleArray(br.readLine().split(" "));
        double x1 = arr[0];
        double v1 = arr[1];
        double x2 = arr[2];
        double v2 = arr[3];
        if (v1 == v2 && x2 != x1){
            System.out.println("NO");
            System.exit(0);
        }
        double steps = (x2 - x1) / (v1 - v2);
        System.out.println(steps == Math.ceil(steps) && steps >= 0 ? "YES" : "NO");
    }

    private static double[] toDoubleArray(String[] arr){
        double[] toReturn = new double[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Double.parseDouble(arr[i]);
        }
        return toReturn;
    }
}
