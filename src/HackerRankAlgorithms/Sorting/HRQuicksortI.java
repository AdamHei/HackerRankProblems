package HackerRankAlgorithms.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
/**
 * Created by Adam on 5/11/2016.
 */
public class HRQuicksortI {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int pivot = Integer.parseInt(br.readLine());
        int[] arr = toIntArray(br.readLine().split(" "));

        ArrayList<Integer> lessThan = new ArrayList<>();
        ArrayList<Integer> equal = new ArrayList<>();
        ArrayList<Integer> greaterThan = new ArrayList<>();

        for (int i: arr){
            if (i > pivot){
                greaterThan.add(i);
            }
            else if (i < pivot){
                lessThan.add(i);
            }
            else{
                equal.add(i);
            }
        }
        print(lessThan);
        print(equal);
        print(greaterThan);
    }

    static void print(ArrayList<Integer> arr){
        for (int i: arr){
            System.out.print(i + " ");
        }
    }

    static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }
}
