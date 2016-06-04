package HackerRankAlgorithms.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Adam on 5/10/2016.
 */
public class SherlockandtheBeast {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();

        String input;
        while ((input = bufferedReader.readLine()) != null){
            findLargestDecentNumber(Integer.parseInt(input));
        }
    }

    private static void findLargestDecentNumber(int n){
        if (n % 3 == 0){
            print(0, n);
        }
        else{
            boolean printed = false;
            for (int j = n; j >= 0; j -= 1){
                if (j % 3 == 0 && (n - j) % 5 == 0){
                    print(n - j, j);
                    printed = true;
                    j = -1;
                }
            }
            if (!printed){
                System.out.println("-1");
            }
        }
    }

    private static void print(int x, int y){
        for (int i = 0; i < y; i += 1){
            System.out.print("5");
        }
        for (int i = 0; i < x; i += 1){
            System.out.print("3");
        }
        System.out.println();
    }
}
