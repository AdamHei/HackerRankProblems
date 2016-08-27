package Contests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Adam on 8/27/2016.
 */
public class BonAppetit {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nandk = toIntArray(br.readLine().split(" "));
        int[] prices = toIntArray(br.readLine().split(" "));
        int bCharged = Integer.parseInt(br.readLine());

        int total = Arrays.stream(prices)
                .filter(price -> price != prices[nandk[1]])
                .sum();

        int bActual = total / 2;
        if (bActual != bCharged){
            System.out.println(bCharged - bActual);
        }
        else {
            System.out.println("Bon Appetit");
        }
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }

}
