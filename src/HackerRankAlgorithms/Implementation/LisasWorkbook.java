package HackerRankAlgorithms.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Adam on 5/17/2016.
 */
public class LisasWorkbook {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = toIntArray(br.readLine().split(" "))[1];
        int[] arr = toIntArray(br.readLine().split(" "));

        ArrayList<ArrayList<Integer>> book = new ArrayList<>();
        book.add(new ArrayList<>());

        for (int i = 0; i < arr.length; i++){
            ArrayList<Integer> toAdd = new ArrayList<>();
            int counter = 0;
            for (int j = 1; j <= arr[i]; j++){
                if (counter == k){
                    counter = 0;
                    book.add(toAdd);
                    toAdd = new ArrayList<>();
                    toAdd.add(j);
                    counter++;
                }
                else{
                    counter++;
                    toAdd.add(j);
                }
            }
            if (counter >= 0){
                book.add(toAdd);
            }
        }

        int total = 0;
        for (int i = 1; i < book.size(); i++){
            for (int j: book.get(i)){
                if (i == j) total++;
            }
        }
        System.out.println(total);
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }
}
