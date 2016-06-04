package HackerRankAlgorithms.Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Adam on 5/19/2016.
 */
public class AlternatingCharacters {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());

        for (int i = 1; i <= cases; i++){
            findDeletions(br.readLine());
        }
    }

    private static void findDeletions(String s){
        char[] arr = s.toCharArray();
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++){
            if (arr[i] == arr[i + 1]){
                char c = arr[i + 1];
                i++;
                boolean executed = false;
                while (i < arr.length && arr[i] == c){
                    executed = true;
                    arr[i] = 'z';
                    count++;
                    i++;
                }
                if (executed) i--;
            }
        }
        System.out.println(count);
    }
}
