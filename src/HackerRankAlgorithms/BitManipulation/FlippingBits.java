package HackerRankAlgorithms.BitManipulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Adam on 5/27/2016.
 */
public class FlippingBits {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine().trim());

        for (int i = 1; i <= cases; i++){
            flippyBit(br.readLine());
        }

    }

    private static void flippyBit(String s){
        long num = Long.parseLong(s.trim());
        char[] arr = Long.toBinaryString(num).toCharArray();
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < 32 - arr.length; i++){
            list.add('0');
        }
        for (char c: arr){
            list.add(c);
        }
        char[] newArr = new char[32];
        for (int i = 0; i < newArr.length; i++){
            newArr[i] = list.get(i);
        }
        for (int i = 0; i < newArr.length; i++){
            if (newArr[i] == '0') newArr[i] = '1';
            else newArr[i] = '0';
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char c: newArr){
            stringBuilder.append(c);
        }
        long newnum = Long.parseLong(stringBuilder.toString(), 2);
        System.out.println(newnum);
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }
}
