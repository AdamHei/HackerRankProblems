package Contests.BookingWomenInTech;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class VisitingManhattan {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] xylh = toIntArray(br.readLine().split(" "));
        int l = xylh[2];
        int h = xylh[3];

        List<Pair> landmarks = new ArrayList<>();
        for (int i = 0; i < l; i++) {
            int[] cords = toIntArray(br.readLine().split(" "));
            landmarks.add(new Pair(cords[0], cords[1]));
        }


        BigInteger xSum = BigInteger.ZERO, xSumSquared = BigInteger.ZERO, ySum = BigInteger.ZERO, ySumSquared = BigInteger.ZERO;
        for (Pair landmark : landmarks) {
            xSum = xSum.add(landmark.X);
            xSumSquared = xSumSquared.add(landmark.X.multiply(landmark.X));

            ySum = ySum.add(landmark.Y);
            ySumSquared = ySumSquared.add(landmark.Y.multiply(landmark.Y));
        }

        BigInteger n = new BigInteger(Integer.toString(landmarks.size()));

        BigInteger minDist = new BigInteger("100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
        BigInteger two = new BigInteger("2");
        int minHotel = 0;
        for (int i = 0; i < h; i++) {
            int[] cords = toIntArray(br.readLine().split(" "));
            Pair hotel = new Pair(cords[0], cords[1]);

            BigInteger nXSq = n.multiply(hotel.X.multiply(hotel.X));
            BigInteger nYSq = n.multiply(hotel.Y.multiply(hotel.Y));

            BigInteger xMiddle = two.multiply(n).multiply(hotel.X).multiply(xSum);
            BigInteger yMiddle = two.multiply(n).multiply(hotel.Y).multiply(ySum);

            BigInteger total = nXSq.add(nYSq).subtract(xMiddle).subtract(yMiddle).add(xSumSquared).add(ySumSquared);

            if (total.compareTo(minDist) < 0){
                minDist = total;
                minHotel = i + 1;
            }
        }

        System.out.println(minHotel);
    }

//    private static int sumToAllLandmarks(List<Pair> landmarks, Pair hotel) {
//        int sum = 0;
//        for (Pair landmark : landmarks) {
//            sum += distance(hotel, landmark);
//        }
//        return sum;
//    }

//    private static double distance(Pair one, Pair two) {
//        return Math.abs(one.X - two.X) + Math.abs(one.Y - two.Y);
//    }

    private static class Pair {
        BigInteger X, Y;

        Pair(int x, int y) {
            X = new BigInteger(Integer.toString(x));
            Y = new BigInteger(Integer.toString(y));
        }
    }

    private static int[] toIntArray(String[] strArr) {
        int[] arr = new int[strArr.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }
        return arr;
    }
}
