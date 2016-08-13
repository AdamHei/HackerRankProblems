package HackerRankAlgorithms.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Adam on 8/13/2016.
 */
public class JumpingOnCloudsRevisited {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nandk = toIntArray(br.readLine().split(" "));
        int n = nandk[0];
        int k = nandk[1];

        int[] clouds = toIntArray(br.readLine().split(" "));

        int energy = 100;
        int cloudIndex = k;
        cloudIndex %= clouds.length;
        energy -= (1 + (clouds[cloudIndex] == 1 ? 2 : 0));
        while (cloudIndex != 0){
            cloudIndex += k;
            cloudIndex %= clouds.length;
            energy -= (1 + (clouds[cloudIndex] == 1 ? 2 : 0));
        }

        System.out.println(energy);
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }}
