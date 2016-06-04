package HackerRankAlgorithms.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Adam on 5/17/2016.
 */
public class CutTheSticks {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

        int[] arr = toIntArray(br.readLine().split(" "));
        while (!isEmpty(arr)){
            cut(arr);
        }
    }

    private static void cut(int[] arr){
        int min = min(arr);
        int count = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] > 0){
                arr[i] -= min;
                count++;
            }
        }
        System.out.println(count);
    }

    private static boolean isEmpty(int[] arr){
        for (int i: arr){
            if (i > 0) return false;
        }
        return true;
    }

    private static int min(int[] arr){
        int min = Integer.MAX_VALUE;
        for (int i: arr){
            if (i > 0){
                min = i < min ? i : min;
            }
        }
        return min;
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }
}
