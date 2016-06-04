package HackerRankAlgorithms.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Created by Adam on 5/11/2016.
 */
public class UtopianTree {

    private static HashMap<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        br.readLine();

//        String input;
//        while ((input = br.readLine()) != null){
//            findHeightRec(Integer.parseInt(input));
//        }
        map = new HashMap<>();
        for (int i = 1; i < 20; i += 1){
            System.out.println(findHeightRec(i));
        }
    }

    private static int findHeightRec(int n){
        if (n == 0){
            return 1;
        }
        else if (map.get(n) != null){
            return map.get(n);
        }
        else if (n % 2 == 1){
            int temp = 2 * findHeightRec(n - 1);
            map.put(n, temp);
            return map.get(n);
        }
        else{
            int temp = findHeightRec(n - 1) + 1;
            map.put(n, temp);
            return map.get(n);
        }
    }

    private static void findHeight(int n){
        if (n == 0){
            System.out.println("1");
        }
        else{
            int temp = 1;
            for (int i = 1; i <= n; i += 1){
                if (i % 2 == 1){
                    temp *= 2;
                }
                else{
                    temp += 1;
                }
            }
            System.out.println(temp);
        }
    }
}
