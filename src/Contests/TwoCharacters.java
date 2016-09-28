package Contests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Fails one case Grrrrrr
 */
public class TwoCharacters {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

        char[] s = br.readLine().toCharArray();
        List<Character> arr = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length; i++) {
            while (i < s.length - 1 && s[i] == s[i + 1]){
                i++;
            }
            arr.add(s[i]);
            set.add(s[i]);
        }

        long maxLength = 0;
        List<Character> list = new ArrayList<>(set);
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                char a = list.get(i);
                char b = list.get(j);

                char temp = '0';
                boolean isAlternating = true;
                for (char c: arr){
                    if (c != a && c != b) continue;
                    if (c == temp) isAlternating = false;
                    temp = c;
                }

                if (isAlternating){
                    long len = arr.stream().filter(character -> character == a || character == b).count();
                    if (len > 1 && len > maxLength){
                        maxLength = len;
                    }
                }
            }
        }
        System.out.println(maxLength);
    }
}
