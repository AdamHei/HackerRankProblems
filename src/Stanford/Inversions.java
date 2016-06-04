package Stanford;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Inversions {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C:/Users/Adam/Desktop/IntegerArray.txt");
        List<String> lines = Files.readAllLines(path);
        long[] arr = new long[lines.size()];
        int i = -1;
        for (String s: lines){
            arr[i += 1] = Integer.parseInt(s);
        }
        System.out.println("Number of inversions = " + mergeSort(arr, 0, arr.length));
    }

    private static long mergeSort(long[] arr, int left, int right){
        if (left == right - 1){
            return 0;
        }
        int mid = (left + right) / 2;

        return mergeSort(arr, left, mid) + mergeSort(arr, mid, right) + merge(arr, left, mid, right);
    }

    private static long merge(long[] arr, int left, int mid, int right){
        int count = 0;
        long[] temp = new long[arr.length];
        int lb = left;
        int hb = mid;

        for (int i = left; i < right; i += 1){
            if (hb >= right || lb < mid && arr[lb] <= arr[hb]){
                temp[i] = arr[lb++];
            }
            else{
                count += (mid - lb);
                temp[i] = arr[hb++];
            }
        }

        System.arraycopy(temp, left, arr, left, right - left);

        return count;
    }
}