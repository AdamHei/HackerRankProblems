package HackerRankAlgorithms.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Adam on 5/11/2016.
 */
public class SherlockAndSquares {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

        String input;
        while ((input = br.readLine()) != null){
            String[] arr = input.split(" ");
            findSquares(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
        }
    }

    private static void findSquares(double x, double y){
        int a = (int) Math.sqrt(x);
        int b = (int) Math.sqrt(y);
        if (a * a == x){
            System.out.println(b - a + 1);
        }
        else{
            System.out.println(b - a);
        }
    }
}
