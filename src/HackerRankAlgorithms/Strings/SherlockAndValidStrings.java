package HackerRankAlgorithms.Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Adam on 6/14/2016.
 */
public class SherlockAndValidStrings {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char[] arr = s.toCharArray();
        Map<Character, Integer> charFrequency = new HashMap<>();

        for (char c: arr){
            if (charFrequency.get(c) == null){
                charFrequency.put(c, 1);
            }
            else{
                charFrequency.put(c, charFrequency.get(c) + 1);
            }
        }

//        for (char c: charFrequency.keySet()){
//            System.out.println("Frequency of " + c + " is: " + charFrequency.get(c));
//        }

        int max= Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        Map<Integer, Integer> freqPartition = new HashMap<>();

        for (Character c: charFrequency.keySet()){
            int frequency = charFrequency.get(c);
            max = frequency > max ? frequency : max;
            min = frequency < min ? frequency : min;
            if (freqPartition.get(frequency) == null){
                freqPartition.put(frequency, 1);
            }
            else{
                freqPartition.put(frequency, freqPartition.get(frequency) + 1);
            }
        }

        if (max - min > 1){
            if (min == 1){
                int count = 0;
                for (char c: charFrequency.keySet()){
                    if (charFrequency.get(c) == 1) count++;
                    if (count > 1){
                        System.out.println("NO");
                        System.exit(0);
                    }
                }
            }
            else{
                System.out.println("NO");
                System.exit(0);
            }
        }

        //frequencyPartition guaranteed to have only two keys
        List<Integer> frequencies = new ArrayList<>();
        frequencies.addAll(freqPartition.keySet());
        if (frequencies.size() < 2){
            System.out.println("YES");
            System.exit(0);
        }

        int newMax;
        if (frequencies.get(0) > frequencies.get(1)){
            newMax = frequencies.get(0);
        }
        else{
            newMax = frequencies.get(1);
        }

        if (freqPartition.get(newMax) <= 1){
            System.out.println("YES");
            System.exit(0);
        }

        long majority = frequencies.get(0) * freqPartition.get(frequencies.get(0));
        long minority = frequencies.get(1) * freqPartition.get(frequencies.get(1));

        if (Math.abs(majority - minority) > 1){
            if (s.length() - Math.max(majority, minority) == 1){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
        else{
            System.out.println("YES");
        }
    }
}
