import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Adam on 6/12/2016.
 */
public class playground {
    public static void main(String[] args) throws IOException {
//        ArrayList<Integer>[] lists = (ArrayList<Integer>[])new ArrayList[50];
//        Arrays.fill(lists, new ArrayList<>());
//        lists[0].add(5);
//        System.out.println(lists[0].get(0));


        List<String> lines = Files.readAllLines(Paths.get("C:/Users/Adam/Desktop/findthediff.txt"));
        int[] firstLine = toIntArray(lines.get(0).split(" "));
        int[] secondLine = toIntArray(lines.get(1).split(" "));

        for (int i = 0; i < Math.min(firstLine.length, secondLine.length); i++){
            int index = i >= 10 ? i : i + 1;
            if (firstLine[i] != secondLine[i]){
                System.out.println("Exp distance from " + (index) + " to 11 was " + secondLine[i]);
                System.out.println("Act distance from " + (index) + " to 11 was " + firstLine[i]);
                System.out.println();
            }
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
