package HackerRankAlgorithms.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Adam on 8/7/2016.
 */
public class StrangeCounter {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long t = Long.parseLong(br.readLine());

        if (t <= 3){
            System.out.println(4 - t);
            System.exit(0);
        }

        long pointer = 3;
        long starter = 3;
        while (pointer < t){
            starter *= 2;
            pointer += starter;
        }
        pointer -= starter;
        pointer++;

        long diff = t - pointer;
        starter -= diff;
        System.out.println(starter);
    }
}
