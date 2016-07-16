package HackerRankAlgorithms.Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Adam on 7/15/2016.
 */
public class BeautifulBinaryString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.readLine();

        String str = br.readLine();
        int count = 0;
        for (int i = 0; i <= str.length() - 3; i++){
            if (str.substring(i, i + 3).equals("010")){
                count++;
                i += 2;
            }
        }
        System.out.println(count);
    }
}
