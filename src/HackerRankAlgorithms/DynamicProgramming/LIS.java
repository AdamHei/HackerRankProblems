package HackerRankAlgorithms.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class LIS
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine().trim());

        int[] arr = new int[cases];
        for (int i = 1; i <= cases; i++){
            arr[i - 1] = Integer.parseInt(br.readLine());
        }

        System.out.println(LongestIncreasingSubsequenceLength(arr, arr.length));
    }


    private static int CeilIndex(int A[], int l, int r, int key)
    {
        while (r - l > 1)
        {
            int m = l + (r - l)/2;
            if (A[m]>=key)
                r = m;
            else
                l = m;
        }
        return r;
    }

    private static int LongestIncreasingSubsequenceLength(int A[], int size)
    {
        int[] tailTable   = new int[size];
        int len; // always points empty slot

        tailTable[0] = A[0];
        len = 1;
        for (int i = 1; i < size; i++)
        {
            if (A[i] < tailTable[0])
                // new smallest value
                tailTable[0] = A[i];

            else if (A[i] > tailTable[len-1])
                // A[i] wants to extend largest subsequence
                tailTable[len++] = A[i];

            else
                // A[i] wants to be current end candidate of an existing
                // subsequence. It will replace ceil value in tailTable
                tailTable[CeilIndex(tailTable, -1, len-1, A[i])] = A[i];
        }

        return len;
    }
}