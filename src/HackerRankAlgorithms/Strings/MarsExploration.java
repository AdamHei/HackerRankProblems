package HackerRankAlgorithms.Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Adam on 8/16/2016.
 */
public class MarsExploration {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String message = br.readLine();
        int count = 0;

        String[] arr = new String[message.length() / 3];
        int pointer = 0;
        for (int i = 0; i < arr.length; i++){
            arr[i] = message.substring(pointer, pointer + 3);
            pointer += 3;
        }

        for (String s: arr){
            if (!s.startsWith("S")) count++;
            if (!s.endsWith("S")) count++;
            if (s.charAt(1) != 'O') count++;
        }

        System.out.println(count);
    }
}
