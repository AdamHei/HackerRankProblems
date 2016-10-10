package HackerRankAlgorithms.DynamicProgramming;

/**
 * Created by Adam on 6/1/2016.
 */
public class KadanesAlgorithm {
    public static void main(String[] args){
        long[] arr = {-5, 2, 4, -999};
        System.out.println(max_subarray(arr));
    }

    /**
     * Not really dynamic ;)
     */
    private static long max_subarray(long[] arr){
        long max_ending_here = 0;
        long max_so_far = 0;
        for (long x: arr){
            max_ending_here = Math.max(0, max_ending_here + x);
            max_so_far = Math.max(max_so_far, max_ending_here);
        }
        return max_so_far;
    }
}
