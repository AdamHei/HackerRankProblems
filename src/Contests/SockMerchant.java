package Contests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Adam on 9/24/2016.
 */
public class SockMerchant {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

        int[] socks = toIntArray(br.readLine().split(" "));
        Set<Integer> set  = new HashSet<>();
        int pairs = 0;
        for (int sock: socks){
            if (set.contains(sock)){
                set.remove(sock);
                pairs++;
            }
            else {
                set.add(sock);
            }
        }

        System.out.println(pairs);
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }
}
