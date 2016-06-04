package HackerRankAlgorithms.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Adam on 5/17/2016.
 */
public class LibraryFine {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] checkedOut = toIntArray(br.readLine().split(" "));
        int[] due = toIntArray(br.readLine().split(" "));

        GregorianCalendar end = new GregorianCalendar(checkedOut[2], checkedOut[1] - 1, checkedOut[0]);
        GregorianCalendar start = new GregorianCalendar(due[2], due[1] - 1, due[0]);

        if (end.get(Calendar.YEAR) < start.get(Calendar.YEAR)){
            System.out.println(0);
        }
        else if (end.get(Calendar.MONTH) < start.get(Calendar.MONTH) && end.get(Calendar.YEAR) == start.get(Calendar.YEAR)){
            System.out.println(0);
        }
        else if (end.get(Calendar.DAY_OF_MONTH) < start.get(Calendar.DAY_OF_MONTH) && end.get(Calendar.MONTH) == start.get(Calendar.MONTH) && end.get(Calendar.YEAR) == start.get(Calendar.YEAR)){
            System.out.println(0);
        }
        else if (end.get(Calendar.YEAR) > start.get(Calendar.YEAR)){
            System.out.println(10000);
        }
        else if (end.get(Calendar.MONTH) > start.get(Calendar.MONTH)){
            System.out.println(500 * (end.get(Calendar.MONTH) - start.get(Calendar.MONTH)));
        }
        else if (end.get(Calendar.DAY_OF_MONTH) > start.get(Calendar.DAY_OF_MONTH)){
            System.out.println(15 * (end.get(Calendar.DAY_OF_MONTH) - start.get(Calendar.DAY_OF_MONTH)));
        }
        else{
            System.out.println(0);
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
