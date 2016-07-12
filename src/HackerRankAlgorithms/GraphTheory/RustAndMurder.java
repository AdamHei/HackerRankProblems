package HackerRankAlgorithms.GraphTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Adam on 7/9/2016.
 */
public class RustAndMurder {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine().trim());

        for (int i = 1; i <= cases; i++){
            int[] nandm = toIntArray(br.readLine().split(" "));
            int numNodes = nandm[0];
            int numEdges = nandm[1];

            @SuppressWarnings("unchecked")
            List<Integer>[] graph = (ArrayList<Integer>[])new ArrayList[numNodes + 1];
            for (int k = 0; k < graph.length; k++){
                graph[k] = new ArrayList<>();
                for (int l = 1; l <= numNodes; l++){
                    if (l != k){
                        graph[k].add(l);
                    }
                }
            }
            int[][] edges = new int[numNodes + 1][numNodes + 1];
            for (int m = 0; m < edges.length; m++){
                Arrays.fill(edges[m], 1);
            }
            for (int k = 0; k < edges.length; k++){
                edges[k][k] = Integer.MAX_VALUE;
            }

            for (int j = 0; j < numEdges; j++){
                int[] xy = toIntArray(br.readLine().split(" "));
                int x = xy[0];
                int y = xy[1];

                edges[x][y] = Integer.MAX_VALUE;
                edges[y][x] = Integer.MAX_VALUE;

                graph[x].remove(graph[x].indexOf(y));
                graph[y].remove(graph[y].indexOf(x));
            }

            int source = Integer.parseInt(br.readLine());
            smartDijkstrasAlgo(graph, edges, source);
        }
    }

    private static void smartDijkstrasAlgo(List<Integer>[] graph, int[][] edges, int source){
        long[] dist = new long[graph.length];
        boolean[] visited = new boolean[graph.length];
        Arrays.fill(dist, Long.MAX_VALUE);

        dist[source] = 0L;
        for (int i = 1; i <= graph.length - 1; i++){
            int u = minDist(dist, visited);
            visited[u] = true;
            if (graph[u].size() > 0){
                for (int neighbor: graph[u]){
                    int weight = edges[u][neighbor];
                    if (!visited[neighbor] && dist[u] + weight < dist[neighbor]){
                        dist[neighbor] = dist[u] + weight;
                    }
                }
            }
        }
        print(dist, source);
    }

    private static int minDist(long[] dist, boolean[] visited){
        long min = Long.MAX_VALUE;
        int minIndex = 0;
        for (int i = 1; i < dist.length; i++){
            if (!visited[i] && dist[i] < min){
                min = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    private static void print(long[] dist, int source){
        for (int i = 1; i < dist.length; i++){
            if (dist[i] == Long.MAX_VALUE){
                System.out.print(-1 + " ");
            }
            else if (i != source){
                System.out.print(dist[i] + " ");
            }
        }
        System.out.println();
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }
}
