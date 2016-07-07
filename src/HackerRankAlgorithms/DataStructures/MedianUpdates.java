package HackerRankAlgorithms.DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Adam on 6/29/2016.
 */
public class MedianUpdates {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine().trim());

        PriorityQueue<Integer> hLow = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> hHigh = new PriorityQueue<>();

        for (int i = 1; i <= cases; i++){
            String[] arr = br.readLine().split(" ");
            char instruction = arr[0].charAt(0);
            int num = Integer.parseInt(arr[1]);
//            System.out.println(instruction + " " + num);

            if (instruction == 'r'){
                if (!hLow.contains(num) && !hHigh.contains(num)){
                    System.out.println("Wrong!");
                }
                else if (hLow.contains(num)){
                    hLow.remove(num);
                    if (hLow.size() == 0 && hHigh.size() == 0)
                        System.out.println("Wrong!");
                    else
                        findNewMedian(hLow, hHigh);
                }
                else{
                    hHigh.remove(num);
                    if (hLow.size() == 0 && hHigh.size() == 0)
                        System.out.println("Wrong!");
                    else
                        findNewMedian(hLow, hHigh);
                }
            }
            else{
                if (hLow.size() == 0 && hHigh.size() == 0){
                    hLow.add(num);
                }
                else if (hLow.size() == 0){
                    if (num < hHigh.peek()){
                        hLow.add(num);
                    }
                    else{
                        hHigh.add(num);
                    }
                }
                else if (hHigh.size() == 0){
                    if (num > hLow.peek()){
                        hHigh.add(num);
                    }
                    else{
                        hLow.add(num);
                    }
                }
                else if (num <= hLow.peek()){
                    hLow.add(num);
                }
                else{
                    hHigh.add(num);
                }
                findNewMedian(hLow, hHigh);
            }
        }
    }

    private static void findNewMedian(PriorityQueue<Integer> hLow, PriorityQueue<Integer> hHigh){
        //If sizes are more than 1 different, rebalance
        while (Math.abs(hHigh.size() - hLow.size()) > 1){
            if (hHigh.size() > hLow.size()){
                hLow.add(hHigh.poll());
            }
            else{
                hHigh.add(hLow.poll());
            }
        }

        //If sizes different, return max/min of bigger heap
        if (hHigh.size() != hLow.size()){
            if (hHigh.size() > hLow.size()){
                System.out.println(hHigh.peek());
            }
            else{
                System.out.println(hLow.peek());
            }
        }
        else{
            System.out.println((double)(hLow.peek() + hHigh.peek()) / 2);
        }
    }
}
