package HackerRankAlgorithms.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Adam on 12/20/2016.
 */
public class DesignerPDFViewer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] charHeights = toIntArray(br.readLine().split(" "));
        char[] str = br.readLine().toCharArray();

        int max = Integer.MIN_VALUE;
        int len = str.length;

        for (char c: str){
            int index = ((int) c) - 97;
            max = Math.max(max, charHeights[index]);
        }

        System.out.println(max * len);
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }
}
