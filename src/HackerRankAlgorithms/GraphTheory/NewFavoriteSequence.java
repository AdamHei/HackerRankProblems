package HackerRankAlgorithms.GraphTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Adam on 6/12/2016.
 */
public class NewFavoriteSequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine().trim());

        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] graph = (ArrayList<Integer>[])new ArrayList[1000001];
        for (int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }


        int[] inDegree = new int[1000001];

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.naturalOrder());
        int maxVal = -1;

        for (int i = 1; i <= cases; i++){
            int previous = 0;
            br.readLine();
            int[] arr = toIntArray(br.readLine().split(" "));
            for (int j = 0; j < arr.length; j++){
                int temp = arr[j];
                maxVal = temp > maxVal ? temp : maxVal;
                if (j != 0){
                    graph[previous].add(temp);
                    inDegree[temp]++;
                }
                previous = temp;
            }
        }

        for (int i = 0; i <= maxVal; i++){
            if (inDegree[i] == 0 && !graph[i].isEmpty()){
                queue.add(i);
            }
        }

        while (!queue.isEmpty()){
            int next = queue.remove();
            System.out.print(next + " ");
            int size = graph[next].size();
            for (int i = 0; i < size; i++){
                int vertex = graph[next].get(i);
                inDegree[vertex]--;
                if (inDegree[vertex] == 0){
                    queue.add(vertex);
                }
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
