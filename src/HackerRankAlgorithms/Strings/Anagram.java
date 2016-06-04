package HackerRankAlgorithms.Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Adam on 5/30/2016.
 */
public class Anagram {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine().trim());

        for (int i = 1; i <= cases; i++){
            findAnagram(br.readLine());
        }
    }

    private static void findAnagram(String s){
        if (s.length() % 2 == 1){
            System.out.println(-1);
            return;
        }
        char[] left = s.substring(0, s.length() / 2).toCharArray();
        char[] right = s.substring(s.length() / 2, s.length()).toCharArray();
        List<Character> list = new ArrayList<>();
        for (char c: right) list.add(c);

        int count = 0;
        for (char aLeft : left) {
            if (!list.contains(aLeft)) {
                count++;
            } else {
                list.remove(list.indexOf(aLeft));
            }
        }
        System.out.println(count);
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }
}
