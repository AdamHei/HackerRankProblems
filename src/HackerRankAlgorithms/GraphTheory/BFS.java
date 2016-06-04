package HackerRankAlgorithms.GraphTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Adam on 5/11/2016.
 */
public class BFS {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testCases; i += 1){
            String[] arr = br.readLine().split(" ");
            Graph graph = new Graph(Integer.parseInt(arr[0]) + 1);
            int numOfEdges = Integer.parseInt(arr[1]);
            for (int k = 0; k < numOfEdges; k += 1){
                String[] edge =br.readLine().split(" ");
                graph.addEdge(Integer.parseInt(edge[0]), Integer.parseInt(edge[1]));
            }
            int starting = Integer.parseInt(br.readLine().trim());

            bfs(graph, starting);
        }
    }

    private static void bfs(Graph graph, int starting){
        int[] distTo = new int[graph.vertices];
        boolean[] marked = new boolean[graph.vertices];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int v = 0; v < graph.vertices; v += 1){
            distTo[v] = Integer.MAX_VALUE;
        }
        distTo[starting] = 0;
        marked[starting] = true;
        deque.add(starting);
        while (!deque.isEmpty()){
            int v = deque.removeFirst();
            for (int w: graph.nodesAndNeighbors.get(v)){
                if (!marked[w]){
                    distTo[w] = distTo[v] + 6;
                    marked[w] = true;
                    deque.add(w);
                }
            }
        }
        for (int i = 1; i < distTo.length; i += 1){
            if (distTo[i] == Integer.MAX_VALUE){
                System.out.print("-1 ");
            }
            else if (i != starting) {
                System.out.print(distTo[i] + " ");
            }
        }
        System.out.println();
    }

    private static class Graph{
        ArrayList<ArrayList<Integer>> nodesAndNeighbors;
        int vertices;
        int edges;

        Graph(int vertices){
            this.vertices = vertices;
            edges = 0;
            nodesAndNeighbors = new ArrayList<>();
            for (int v = 0; v < vertices; v += 1){
                nodesAndNeighbors.add(new ArrayList<>());
            }
        }

        void addEdge(int v, int w){
            edges += 1;
            nodesAndNeighbors.get(v).add(w);
            nodesAndNeighbors.get(w).add(v);
        }

        public String toString(){
            StringBuilder s = new StringBuilder();
            s.append(vertices - 1).append(" vertices, ").append(edges).append(" edges \n");
            for (int v = 0; v < vertices; v++){
                s.append(v).append(": ");
                for (int w: nodesAndNeighbors.get(v)){
                    s.append(w).append(" ");
                }
                s.append("\n");
            }
            return s.toString();
        }
    }

}