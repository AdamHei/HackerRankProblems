package Contests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Adam on 9/28/2016.
 */
public class SmallRiskTrading {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nandk = toIntArray(br.readLine().split(" "));
        int k = nandk[1];

        double[] probabilities = toDoubleArray(br.readLine().split(" "));
        double[] profits = toDoubleArray(br.readLine().split(" "));
        double[] losses = toDoubleArray(br.readLine().split(" "));

        List<Trade> trades = new ArrayList<>();
        for (int i = 0; i < probabilities.length; i++) {
            trades.add(new Trade(profits[i], probabilities[i], losses[i]));
        }

        Collections.sort(trades);

        double potentialProfit = 0;

        int i = nandk[0] - k;
        for (; i < nandk[0]; i++){
            if (trades.get(i).potential > 0.00){
                potentialProfit += trades.get(i).potential;
            }
        }


//        int i = trades.size() - 1;
//        while (trades.size() - 1 - i < k && potentialProfit + trades.get(i).potential > potentialProfit){
//            potentialProfit += trades.get(i).potential;
//            i--;
//        }

        BigDecimal profit = new BigDecimal(potentialProfit);
        profit = profit.setScale(2, BigDecimal.ROUND_CEILING);
        System.out.println(profit);
    }

    private static class Trade implements Comparable<Trade>{
        double potentialProfit, probability, potentialLoss;
        double potential;

        Trade(double prof, double prob, double loss){
            this.potentialProfit = prof;
            this.probability = prob;
            this.potentialLoss = loss;
            this.potential = this.potentialProfit * this.probability - (1 - this.probability) * potentialLoss;
        }

        @Override
        public int compareTo(Trade o) {
            if (this.potential < o.potential){
                return -1;
            }
            else if (this.potential > o.potential){
                return 1;
            }
            return 0;
        }

        void print(){
            System.out.println("Profit: " + this.potentialProfit);
            System.out.println("Loss: " + this.potentialLoss);
            System.out.println("Probability: " + this.probability);
            System.out.println("Potential: " + this.potential);
            System.out.println();
        }
    }

    private static double[] toDoubleArray(String[] arr){
        double[] toReturn = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            toReturn[i] = Double.parseDouble(arr[i]);
        }
        return toReturn;
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }
}
