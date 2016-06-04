package HackerRankAlgorithms.Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Adam on 5/19/2016.
 */
public class GameOfThrones {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        confirmPalindrome(br.readLine().toCharArray());
    }

    private static void confirmPalindrome(char[] string){
        boolean isOdd = string.length % 2 == 1;

        int[] arr = new int[26];

        for (char aString : string) {
            arr[aString - 97] += 1;
        }

        if (isOdd){
            boolean alreadyTaken = false;

            for (int anArr : arr) {
                if (anArr % 2 == 1 && alreadyTaken) {
                    System.out.println("NO");
                    return;
                }
                else if (anArr % 2 == 1){
                    alreadyTaken = true;
                }
            }
        }
        else{
            for (int i: arr){
                if (i % 2 != 0){
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");
    }
}
