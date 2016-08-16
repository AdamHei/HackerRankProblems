package HackerRankAlgorithms.Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Adam on 8/16/2016.
 */
public class Gemstones {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine().trim());
        Set<Character> set = new HashSet<>();
        for (char c: br.readLine().toCharArray()){
            set.add(c);
        }

        for (int i = 2; i <= cases; i++){
            String s = br.readLine();
            Set<Character> comp = new HashSet<>();
            for (char c: s.toCharArray()){
                comp.add(c);
            }

            Iterator<Character> iter = set.iterator();
            char c;
            while (iter.hasNext()){
                c = iter.next();
                if (!comp.contains(c)){
                    iter.remove();
                }
            }
        }

        System.out.println(set.size());
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }
}
