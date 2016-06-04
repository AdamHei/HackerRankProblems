package HackerRankAlgorithms.Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Adam on 5/16/2016.
 */
public class Pangrams {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        char[] arr = line.replaceAll(" ", "").toLowerCase().toCharArray();
        if (arr.length < 26){
            System.out.println("not pangram");
        }
        else{
            boolean[] chars = new boolean[26];
            Arrays.fill(chars, false);
            for (char c: arr){
                if (!chars[c - 97]){
                    chars[c - 97] = true;
                }
            }
            for (boolean b: chars){
                if (!b){
                    System.out.println("not pangram");
                    System.exit(0);
                }
            }
            System.out.println("pangram");
        }
    }
}
