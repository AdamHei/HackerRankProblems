package HackerRankAlgorithms.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Adam on 5/14/2016.
 */
public class SherlockandWatson {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] properties = br.readLine().split(" ");

        int rotations = Integer.parseInt(properties[1]);

        String[] arr = br.readLine().split(" ");
        ArrayList<Integer> indicesToCheck = new ArrayList<>();

        for (int i = 0; i < Integer.parseInt(properties[2]); i += 1){
            indicesToCheck.add(Integer.parseInt(br.readLine()));
        }

//        String input;
//        while ((input = br.readLine()) != null){
//            indicesToCheck.add(Integer.parseInt(input));
//        }

        ArrayList<Integer> list = toList(arr);
        rotate(rotations, list);
        for (int i: indicesToCheck){
            System.out.println(list.get(i));
        }
    }

    private static void rotate(int rotations, ArrayList<Integer> list){
        for (int i = 0; i < rotations; i += 1){
            list.add(0, list.remove(list.size() - 1));
        }
    }

    private static ArrayList<Integer> toList(String[] arr){
        ArrayList<Integer> toReturn = new ArrayList<>();
        for (String s: arr){
            toReturn.add(Integer.parseInt(s));
        }
        return toReturn;
    }
}
