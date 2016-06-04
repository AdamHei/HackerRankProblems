import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Adam on 5/11/2016.
 */
public class Template {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine().trim());

        for (int i = 1; i <= cases; i++){

        }
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }

    public static void print(int[] arr){
        for (int i: arr){
            System.out.print(i + " ");
        }
    }

    static void print(ArrayList<Integer> arr){
        for (int i: arr){
            System.out.print(i + " ");
        }
    }
}
