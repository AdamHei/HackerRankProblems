package Contests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FraudulentActivityNotifications {

    private static PriorityQueue<Integer> hLow = new PriorityQueue<>(Comparator.reverseOrder());
    private static PriorityQueue<Integer> hHigh = new PriorityQueue<>();
    private static boolean dOdd;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int d = Integer.parseInt(br.readLine().split(" ")[1]);
        dOdd = d % 2 == 1;

        int[] transations = toIntArray(br.readLine().split(" "));

        if (transations.length <= d){
            System.out.println(0);
            System.exit(0);
        }

        int[] initialD = Arrays.copyOf(transations, d);
        Arrays.sort(initialD);

        int halfway = d % 2 == 0 ? d / 2 : d / 2 + 1;
        for (int i = 0; i < halfway; i++) {
            hLow.add(initialD[i]);
        }
        for (int i = halfway; i < initialD.length; i++) {
            hHigh.add(initialD[i]);
        }

        int notifications = 0;
        for (int i = d; i < transations.length; i++) {
            //Compare against median
            int nextTrans = transations[i];
            double median;
            if (dOdd){
                median = hLow.peek();
            }
            else {
                double low = hLow.peek();
                double high = hHigh.peek();
                median = (low + high) / 2;
            }

            if (nextTrans >= 2 * median) notifications++;

            //Remove transactions[i - d]
            if (transations[i - d] <= median){
                hLow.remove(transations[i - d]);
            }
            else {
                hHigh.remove(transations[i - d]);
            }

            reBalance();

            if (nextTrans <= hLow.peek()){
                hLow.add(nextTrans);
            }
            else {
                hHigh.add(nextTrans);
            }

            reBalance();
        }
        System.out.println(notifications);
    }

    private static void reBalance(){
        if (dOdd){
            if (hLow.size() < hHigh.size() + 1){
                hLow.add(hHigh.poll());
            }
            else if (hHigh.size() < hLow.size() - 1){
                hHigh.add(hLow.poll());
            }
        }
        else if (hLow.size() > hHigh.size()){
            hHigh.add(hLow.poll());
        }
        else if (hHigh.size() > hLow.size()){
            hLow.add(hHigh.poll());
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
