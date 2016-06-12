package HackerRankAlgorithms.GraphTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Digraph<V> {

    private static class Edge<V> {
        private V vertex;

        Edge(V v) {
            vertex = v;
        }

        public V getVertex() {
            return vertex;
        }
    }

    private Map<V, List<Edge<V>>> neighbors = new HashMap<>();

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (V v : neighbors.keySet())
            s.append("\n    ").append(v).append(" -> ").append(neighbors.get(v));
        return s.toString();
    }

    public void add(V vertex) {
        if (neighbors.containsKey(vertex))
            return;
        neighbors.put(vertex, new ArrayList<>());
    }

    private int getNumberOfEdges(){
        int sum = 0;
        for(List<Edge<V>> outBounds : neighbors.values()){
            sum += outBounds.size();
        }
        return sum;
    }

    public boolean contains(V vertex) {
        return neighbors.containsKey(vertex);
    }

    public void add(V from, V to) {
        this.add(from);
        this.add(to);
        neighbors.get(from).add(new Edge<>(to));
    }

//    private int outDegree(int vertex) {
//        return neighbors.get(vertex).size();
//    }

    private int inDegree(V vertex) {
        return inboundNeighbors(vertex).size();
    }

//    private List<V> outboundNeighbors(V vertex) {
//        List<V> list = new ArrayList<V>();
//        for(Edge<V> e: neighbors.get(vertex))
//            list.add(e.vertex);
//        return list;
//    }

    private List<V> inboundNeighbors(V inboundVertex) {
        List<V> inList = new ArrayList<>();
        for (V to : neighbors.keySet()) {
            for (Edge e : neighbors.get(to))
                if (e.vertex.equals(inboundVertex))
                    inList.add(to);
        }
        return inList;
    }

//    private boolean isEdge(V from, V to) {
//        for(Edge<V> e :  neighbors.get(from)){
//            if(e.vertex.equals(to))
//                return true;
//        }
//        return false;
//    }

    private static Digraph<Integer> graph;

    private static Map<Integer, Integer> inDegrees;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        graph = new Digraph<>();

        for (int i = 0; i < n; i++){
            br.readLine();
            int[] sheet = toIntArray(br.readLine().split(" "));
            for (int j = 0; j < sheet.length - 1; j++){
                graph.add(sheet[j], sheet[j + 1]);
            }
        }

        inDegrees = new HashMap<>();
        for (int key: graph.neighbors.keySet()){
            inDegrees.put(key, graph.inDegree(key));
        }

        topologicalSort();
    }

    private static void topologicalSort(){
        Comparator<Integer> comparator = new VertexComparator();
        List<Integer> original = new ArrayList<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(comparator);
        priorityQueue.addAll(graph.neighbors.keySet());

        while (priorityQueue.size() > 0){
            int vert = priorityQueue.remove();
            original.add(vert);


            //TESTING
            for (Edge<Integer> neighbor: graph.neighbors.get(vert)){
                inDegrees.put(neighbor.vertex, 0);
            }


            graph.neighbors.remove(vert);


//            TESTING
            priorityQueue.clear();
            priorityQueue.addAll(graph.neighbors.keySet());
        }
        for (int num: original){
            System.out.print(num + " ");
        }
    }

    private static class VertexComparator implements Comparator<Integer>{

        @Override
        public int compare(Integer x, Integer y) {
//            if (graph.inDegree(x) < graph.inDegree(y)){
//                return -1;
//            }
//            else if (graph.inDegree(x) > graph.inDegree(y)){
//                return 1;
//            }
            if (inDegrees.get(x) < inDegrees.get(y)){
                return -1;
            }
            else if (inDegrees.get(x) > inDegrees.get(y)){
                return 1;
            }
            else{
                if (x < y){
                    return -1;
                }
                else{
                    return 1;
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