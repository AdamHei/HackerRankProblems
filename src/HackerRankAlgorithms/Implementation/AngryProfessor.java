package HackerRankAlgorithms.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AngryProfessor {

    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(bufferedReader.readLine());
        int k = 0;
        for (int i = 0; i < testCases * 2; i += 1){
            if (i % 2 == 0){
                String[] arr = bufferedReader.readLine().split(" ");
                k = Integer.parseInt(arr[1]);
            }
            else{
                System.out.println(isClassCancelled(k, bufferedReader.readLine().split(" ")) ? "YES" : "NO");
            }
        }
    }

    private static boolean isClassCancelled(int k, String[] arrivalTimes){
        int[] times = new int[arrivalTimes.length];
        int i = -1;
        for (String s: arrivalTimes){
            times[i += 1] = Integer.parseInt(s);
        }

        Arrays.sort(times);

        int tempCount = 0;
        for (int j: times){
            if (j > 0) return tempCount < k;
            tempCount += 1;
        }
        return false;
    }
}
