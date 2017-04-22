package Contests.BookingWomenInTech;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Adam on 4/21/2017.
 */
public class HighlightLandmarks {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String description = br.readLine();
        String[] descripArr = description.split(" ");

        int L = Integer.parseInt(br.readLine().trim());

        String[] landmarks = br.readLine().split(" ");
        Set<String> landSet = new HashSet<>();
        landSet.addAll(Arrays.asList(landmarks));

        for (int i = 0; i < descripArr.length; i++) {
            if (landSet.contains(descripArr[i])){
                descripArr[i] = "<b>" + descripArr[i] + "</b>";
            }
        }

        for (String s: descripArr){
            System.out.print(s + " ");
        }
    }
}
