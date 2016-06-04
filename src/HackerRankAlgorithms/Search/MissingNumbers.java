package HackerRankAlgorithms.Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Adam on 5/16/2016.
 */
public class MissingNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.readLine();
        int[] original = toIntArray(br.readLine().split(" "));
        br.readLine();
        int[] perm = toIntArray(br.readLine().split(" "));

        parse(original, perm);
    }

    private static void parse(int[] original, int[] perm){
        HashMap<Integer, Integer> map = new HashMap<>();
        //Find the frequency of every number in the permutation
        for (int i: perm){
            if (map.get(i) == null){
                map.put(i, 1);
            }
            else{
                map.put(i, map.get(i) + 1);
            }
        }

        //Lessen frequency for every occurence in the original array
        for (int j: original){
            map.put(j, map.get(j) - 1);
        }

        ArrayList<Integer> missing = new ArrayList<>();

        //Find the missing elements
        for (int i: map.keySet()){
            if (map.get(i) > 0){
                missing.add(i);
            }
        }

        int[] arr = convertIntegers(missing);
        Arrays.sort(arr);
        for (int i: arr){
            System.out.print(i + " ");
        }
    }

    private static int[] convertIntegers(ArrayList<Integer> integers)
    {
        int[] ret = new int[integers.size()];
        for (int i=0; i < ret.length; i++)
        {
            ret[i] = integers.get(i);
        }
        return ret;
    }

    public static void print(int[] arr){
        for (int i: arr){
            System.out.print(i + " ");
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
