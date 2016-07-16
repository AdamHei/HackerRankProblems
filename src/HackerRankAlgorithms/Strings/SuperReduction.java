package HackerRankAlgorithms.Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Adam on 7/15/2016.
 */
public class SuperReduction {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();

        int index = findDupesIndex(word);
        while (index != -1){
            word = word.substring(0, index) + word.substring(index + 2);
            index = findDupesIndex(word);
        }

        System.out.println(word.length() == 0 ? "Empty String" : word);
    }

    private static int findDupesIndex(String s){
        for (int j = 0; j < s.length() - 1; j++){
            if (s.charAt(j) == s.charAt(j + 1)){
                return j;
            }
        }
        return -1;
    }
}
