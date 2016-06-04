package HackerRankAlgorithms.Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Adam on 5/27/2016.
 */
public class TwoStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine().trim());

        for (int i = 1; i <= cases; i++){
            findSubstring(br.readLine().trim(), br.readLine().trim());
        }
    }

    private static void findSubstring(String a, String b){
        Set<Character> aSet = new HashSet<>();
        for (char c: a.toCharArray()){
            aSet.add(c);
        }
        if (aSet.size() > 26){
            System.out.println("YES");
            return;
        }
        Set<Character> bSet = new HashSet<>();
        for (char c: b.toCharArray()){
            bSet.add(c);
        }
        if (bSet.size() > 26 && aSet.size() > 0){
            System.out.println("YES");
            return;
        }
        if (a.length() < b.length()){
            for (char c: a.toCharArray()){
                if (bSet.contains(c)) {
                    System.out.println("YES");
                    return;
                }
            }
        }
        else{
            for (char c: b.toCharArray()){
                if (aSet.contains(c)){
                    System.out.println("YES");
                    return;
                }
            }
        }
        System.out.println("NO");

    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }
}
