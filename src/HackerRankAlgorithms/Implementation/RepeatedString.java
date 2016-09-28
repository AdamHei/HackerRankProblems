package HackerRankAlgorithms.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Adam on 9/23/2016.
 */
public class RepeatedString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        long n = Long.parseLong(br.readLine());

        if (n < s.length()) {
            int aaas = 0;
            for (int i = 0; i <= n; i++) {
                if (s.charAt(i) == 'a') aaas++;
            }
            System.out.println(aaas);
        }
        else {
            int aaas = 0;
            for (char c : s.toCharArray()) {
                if (c == 'a') aaas++;
            }
            long total = (n / s.length()) * aaas;
            n = n % s.length();
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == 'a') total++;
            }
            System.out.println(total);
        }
    }
}
