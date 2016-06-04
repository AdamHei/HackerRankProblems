package HackerRankAlgorithms.Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Adam on 5/27/2016.
 */
public class FunnyString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine().trim());

        for (int i = 1; i <= cases; i++){
            isFunny(br.readLine());
        }
    }

    private static void isFunny(String string){
        char[] s = string.toCharArray();
        char[] r = new char[s.length];
        for (int i = 0; i < s.length; i++){
            r[i] = s[s.length - i - 1];
        }

        for (int i = 1; i < s.length; i++){
            if (Math.abs(s[i] - s[i - 1]) != Math.abs(r[i] - r[i - 1])){
                System.out.println("Not Funny");
                return;
            }
        }
        System.out.println("Funny");
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }
}
