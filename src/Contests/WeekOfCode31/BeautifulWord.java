package Contests.WeekOfCode31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BeautifulWord {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String w = br.readLine().trim();
        String vowels = "aeiouy";

        for (int i = 0; i < w.length() - 1; i++) {
            char left = w.charAt(i), right = w.charAt(i + 1);
            if (left == right || (vowels.indexOf(left) >= 0 && vowels.indexOf(right) >= 0)) {
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");
    }

    private static int[] toIntArray(String[] strArr) {
        int[] arr = new int[strArr.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }
        return arr;
    }
}
