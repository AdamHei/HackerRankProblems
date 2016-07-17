package HackerRankAlgorithms.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Adam on 7/17/2016.
 */
public class JumpingOnTheClouds {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

        int[] clouds = toIntArray(br.readLine().split(" "));

        int jumps = -1;
        for (int i = 0; i < clouds.length; i++){
            jumps++;
            if (i < clouds.length - 2 && clouds[i + 2] == 0){
                i++;
            }
        }

        System.out.println(jumps);
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }
}
