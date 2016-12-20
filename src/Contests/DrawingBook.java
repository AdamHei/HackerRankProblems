package Contests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Adam on 12/20/2016.
 */
public class DrawingBook {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int p = Integer.parseInt(br.readLine());

        if (n <= 3){
            if (n == 1 || p == 1) System.out.println(0);
            else System.out.println(1);
            return;
        }

        int mid = n / 2;

        if (p <= mid) {
            System.out.println(p / 2);
        }
        else {
            if (n % 2 == 1 && (p == n || p == n - 1)){
                System.out.println(0);
            }
            else {
                System.out.println(((n + 1) - p) / 2);
            }
        }
    }
}
