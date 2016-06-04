package HackerRankAlgorithms.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Adam on 5/11/2016.
 */
public class SortingI {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numToFind = Integer.parseInt(br.readLine());
        br.readLine();
        String[] arr = br.readLine().split(" ");
        int[] toParse = new int[arr.length];
        for (int j = 0; j < toParse.length; j += 1){
            toParse[j] = Integer.parseInt(arr[j]);
        }
        findNum(numToFind, toParse);
    }

    private static void findNum(int num, int[] toParse){
        for (int i = 0; i < toParse.length; i += 1){
            if (toParse[i] == num){
                System.out.println(i);
                return;
            }
        }
        System.out.println();
    }
}
