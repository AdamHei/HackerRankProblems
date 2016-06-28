package Contests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Adam on 6/27/2016.
 */
public class LuckBalance {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nandk = toIntArray(br.readLine().split(" "));
        int n = nandk[0];
        int k = nandk[1];

        List<Integer> unimportantContests = new ArrayList<>();
        List<Integer> importantContests = new ArrayList<>();

        for (int i = 0; i < n; i++){
            int[] contest = toIntArray(br.readLine().split(" "));
            if (contest[1] == 1){
                importantContests.add(contest[0]);
            }
            else{
                unimportantContests.add(contest[0]);
            }
        }

        long endingBalance = 0;
        for (int i: unimportantContests){
            endingBalance += i;
        }

        Collections.sort(importantContests);
        for (int i = 0; i < importantContests.size(); i++){
            if (i < importantContests.size() - k){
                endingBalance -= importantContests.get(i);
            }
            else{
                endingBalance += importantContests.get(i);
            }
        }

        System.out.println(endingBalance);
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }
}
