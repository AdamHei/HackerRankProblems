package HackerRankAlgorithms.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Adam on 5/17/2016.
 */
public class TaumBDay {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());

        for (int i = 1; i <= cases; i++){
            int[] bAndW = toIntArray(br.readLine().split(" "));
            int[] prices = toIntArray(br.readLine().split(" "));
//            findCost(bAndW[0], bAndW[1], prices[0], prices[1], prices[2]);
        }
    }

//    private static void findCost(int black, int white, int bCost, int wCost, int convert) {
//        if (convert + wCost < bCost){
//            System.out.println(black * (wCost + convert) + white * wCost);
//        }
//        else if (convert + bCost < wCost){
//            System.out.println(white * (convert + bCost) + black * bCost);
//        }
//        else{
//            System.out.println(black * bCost + white * wCost);
//        }
//    }

//    private static void findCost(int black, int white, int bCost, int wCost, int convert){
//        long bTotal = black * bCost;
//        long wTotal = wCost * white;
//        if (bCost == wCost){
//            System.out.println(bTotal + wTotal);
//        }
//        else if (bCost < wCost){
//            if (bCost + convert < wCost){
//                System.out.println((white * bCost + white * convert) + bTotal);
//            }
//            else{
//                System.out.println(bTotal + wTotal);
//            }
//        }
//        else{
//            if (wCost + convert < bCost){
//                System.out.println((black * wCost + black * convert) + wTotal);
//            }
//            else{
//                System.out.println(bTotal + wTotal);
//            }
//        }
//    }

//    private static void findCost(int black, int white, int bCost, int wCost, int convert){
//        long toPrint = 0;
//        long first = black * bCost + (bCost + convert) * white;
//        long second = white * wCost + (wCost + convert) * black;
//        long third = white * wCost + black * bCost;
//
//        toPrint = Math.min(first, second);
//        toPrint = Math.min(toPrint, third);
//
//        System.out.println(toPrint);
//    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }
}
