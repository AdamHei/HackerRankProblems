package HackerRankAlgorithms.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Adam on 7/16/2016.
 */
public class MarkAndToys {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nandk = toIntArray(br.readLine().split(" "));

        int[] prices = toIntArray(br.readLine().split(" "));
        Arrays.sort(prices);

        int canBuy = 0;
        int totalPrice = 0;
        for (int price: prices){
            if (totalPrice + price <= nandk[1]){
                canBuy++;
                totalPrice += price;
            }
        }

        System.out.println(canBuy);
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }
}
