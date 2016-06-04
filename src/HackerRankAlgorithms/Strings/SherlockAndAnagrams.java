package HackerRankAlgorithms.Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Adam on 5/30/2016.
 */
public class SherlockAndAnagrams {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine().trim());

        for (int i = 1; i <= cases; i++){
            findAnagrams(br.readLine().trim());
        }
    }

    /**
     * Prints the number of unsorted anagrammatic pairs in the given string
     * First we find all substrings of the given string and sort each one
     * Then we sort that list of substrings
     * Next we iterate over each substring in the list and check if we've seen it
     * before.
     * If we have we update the number of possible pairs using the binomial coefficient
     * If not, we just add it to the list
     * In the end, we count how many combinations we found and print it
     * @param s
     */
    private static void findAnagrams(String s){
        List<String> list = subStringGenerator(s);
        Collections.sort(list);
        Map<String, Integer> countMap = new HashMap<>();
        Map<String, Long> combinationsMap = new HashMap<>();
        long count = 0;

        while (!list.isEmpty()){
            String temp = list.remove(0);
            if (countMap.get(temp) != null){
                countMap.put(temp, countMap.get(temp) + 1);
                long combo = binomial(countMap.get(temp), 2);
                combinationsMap.put(temp, combo);
            }
            else{
                countMap.put(temp, 1);
                combinationsMap.put(temp, (long) 0);
            }
        }

        for (String string: combinationsMap.keySet()){
            long temp = combinationsMap.get(string);
            if (temp != 0){
                count += temp;
            }
        }

        System.out.println(count);
    }

    private static long binomial(int n, int k)
    {
        if (k>n-k)
            k=n-k;

        long b=1;
        for (int i=1, m=n; i<=k; i++, m--)
            b=b*m/i;
        return b;
    }

    private static List<String> subStringGenerator(String s){
        List<String> list = new ArrayList<>();
        StringBuilder stringBuilder;
        for (int i = 0; i < s.length(); i++){
            for (int c = 1; c <= s.length() - i; c++){
                stringBuilder = new StringBuilder();
                char[] temp = s.substring(i, i + c).toCharArray();
                Arrays.sort(temp);
                for (char ch: temp) stringBuilder.append(ch);
                list.add(stringBuilder.toString());
            }
        }
        return list;
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }
}
