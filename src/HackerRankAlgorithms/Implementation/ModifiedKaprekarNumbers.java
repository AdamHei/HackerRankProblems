package HackerRankAlgorithms.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Adam on 5/27/2016.
 */
public class ModifiedKaprekarNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int p = Integer.parseInt(br.readLine().trim());
        int q = Integer.parseInt(br.readLine().trim());

        boolean flag = false;
        for (int i = p; i <= q; i++){
            if (isKaprekar(i)) {
                System.out.print(i + " ");
                flag = true;
            }
        }
        if (!flag) System.out.println("INVALID RANGE");
    }

    private static boolean isKaprekar(long num){
        if (num == 1) return true;
        if (num <= 0) return false;
        long square = num * num;
        long left, right;
        String squareString = Long.toString(square);

//        System.out.println(squareString.substring(0, squareString.length() - Integer.toString(num).length()));
//        System.out.println(squareString.substring(squareString.length() - Integer.toString(num).length(), squareString.length()));

        String l = squareString.substring(0, squareString.length() - Long.toString(num).length());
        left = Long.parseLong("0" + l);
        String r = squareString.substring(squareString.length() - Long.toString(num).length(), squareString.length());
        right = Long.parseLong("0" + r);

        return left + right == num;

//        System.out.println(left);
//        System.out.println(right);
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }
}
