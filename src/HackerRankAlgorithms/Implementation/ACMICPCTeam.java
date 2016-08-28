package HackerRankAlgorithms.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Adam on 8/28/2016.
 */
public class ACMICPCTeam {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nandm = toIntArray(br.readLine().split(" "));
        int n = nandm[0];

        List<String> teammates = new ArrayList<>();
        for (int i = 1; i <= n; i++){
            teammates.add(br.readLine());
        }

        int maxTopics = 0;
        Set<Ent> set = new HashSet<>();

        for (int i = 0; i < teammates.size() - 1; i++){
            BitSet original = stringToBitSet(teammates.get(i));
            for (int j = i + 1; j < teammates.size(); j++){
                BitSet temp = (BitSet) original.clone();
                BitSet compare = stringToBitSet(teammates.get(j));
                temp.or(compare);

                int totalTopics = 0;
                for (int k = 0; k < temp.length(); k++){
                    if (temp.get(k)) totalTopics++;
                }
                if (totalTopics == maxTopics){
                    set.add(new Ent(i, j));
                }
                else if (totalTopics > maxTopics){
                    set.clear();
                    maxTopics = totalTopics;
                    set.add(new Ent(i, j));
                }
            }
        }

        System.out.println(maxTopics);
        System.out.println(set.size());
    }

    private static class Ent implements Map.Entry<Integer, Integer>{
        int key, value;

        Ent(int i, int j){
            key = i;
            value = j;
        }

        @Override
        public Integer getKey() {
            return key;
        }

        @Override
        public Integer getValue() {
            return value;
        }

        @Override
        public Integer setValue(Integer value) {
            return null;
        }
    }

    private static BitSet stringToBitSet(String s){
        BitSet set = new BitSet(s.length());
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '1') {
                set.set(i);
            }
        }
        return set;
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }

}
