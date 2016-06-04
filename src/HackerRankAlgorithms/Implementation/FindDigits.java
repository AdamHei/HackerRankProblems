package HackerRankAlgorithms.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Adam on 5/11/2016.
 */
public class FindDigits {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

        String input;
        while ((input = br.readLine()) != null){
            findDigits(Integer.parseInt(input));
        }
    }

    private static void findDigits(int n){
        int counter = 0;
        int temp = n;
        int num;
        while (temp >= 1){
            num = temp % 10;
            if (num != 0 && n % num == 0){
                counter += 1;
            }
            temp /= 10;
        }
        System.out.println(counter);
    }
}
