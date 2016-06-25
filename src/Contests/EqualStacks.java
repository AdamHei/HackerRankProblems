package Contests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Adam on 6/25/2016.
 */
public class EqualStacks {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = toIntArray(br.readLine().split(" ")).length;

        List<Stack<Integer>> list = new ArrayList<>();

        list.add(arrToStack(toIntArray(br.readLine().split(" "))));
        list.add(arrToStack(toIntArray(br.readLine().split(" "))));
        list.add(arrToStack(toIntArray(br.readLine().split(" "))));

        long[] height = {height(list.get(0)), height(list.get(1)), height(list.get(2))};

        while (height[0] != height[1] || height[0] != height[2]){
            long max = Long.MIN_VALUE;
            int index = 0;
            for (int i = 0; i < height.length; i++){
                if (height[i] > max){
                    max = height[i];
                    index = i;
                }
            }
            height[index] -= list.get(index).pop();
        }

        System.out.println(height[0]);
    }

    private static long height(Stack<Integer> stack){
        long sum = 0;
        for (int i: stack){
            sum += i;
        }
        return sum;
    }

    private static Stack<Integer> arrToStack(int[] arr){
        Stack<Integer> toReturn = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--){
            toReturn.push(arr[i]);
        }
        return toReturn;
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }
}
