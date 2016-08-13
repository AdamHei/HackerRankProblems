package HackerRankAlgorithms.Implementation;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Adam on 8/13/2016.
 */
public class FlatlandSpaceStations {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nandm = toIntArray(br.readLine().split(" "));
        int[] spaceStations = toIntArray(br.readLine().split(" "));

        Arrays.sort(spaceStations);

        int[] stationsArr = new int[nandm[0]];
        for (int i: spaceStations){
            stationsArr[i] = 1;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nandm[0]; i++){
            if (stationsArr[i] == 1){
                max = Math.max(max, 0);
                continue;
            }
            int rightPointer = i;
            while (rightPointer < nandm[0] && stationsArr[rightPointer] == 0){
                rightPointer++;
            }
            int leftPointer = i;
            while (leftPointer >= 0 && stationsArr[leftPointer] == 0){
                leftPointer--;
            }
            if (leftPointer < 0 || stationsArr[leftPointer] != 1){
                if (rightPointer < nandm[0] && stationsArr[rightPointer] == 1){
                    max = Math.max(max, rightPointer - i);
                }
            }
            else if (rightPointer >= nandm[0] || stationsArr[rightPointer] != 1){
                max = Math.max(i - leftPointer, max);
            }
            else {
                int closest = Math.min(i - leftPointer, rightPointer - i);
                max = Math.max(max, closest);
            }
        }
        System.out.println(max);
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }
}
