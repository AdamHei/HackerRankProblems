package HackerRankAlgorithms.GraphTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Adam on 6/6/2016.
 */

/**
 * Does not work. Refer to python code
 */
public class SneksAndLedders {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int cases = Integer.parseInt(br.readLine().trim());

//        int[] moves = new int[100];
//        Arrays.fill(moves, -1);
//        moves[3] = 54;
//        moves[37] = 100;
//        moves[56] = 33;
//        leMinRolls(moves);

        Map<Integer, Integer> map = new HashMap<>();
        map.put(3, 54);
        map.put(37, 100);
        map.put(56, 33);
        stolenFromPython(map);

//        for (int i = 1; i <= cases; i++){
//            int[] moves = new int[100];
//            Arrays.fill(moves, -1);
//
//            int ladders = Integer.parseInt(br.readLine().trim());
//            for (int l = 1; l <= ladders; l++){
//                int[] edge = toIntArray(br.readLine().split(" "));
//                moves[edge[0]] = edge[1];
//            }
//            int sneks = Integer.parseInt(br.readLine().trim());
//            for (int s = 1; s <= sneks; s++){
//                int[] edge = toIntArray(br.readLine().split(" "));
//                moves[edge[0]] = edge[1];
//            }
//
//            leMinRolls(moves);
//        }
    }

    private static void stolenFromPython(Map<Integer, Integer> map){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        Map<Integer, List<Integer>> path = new HashMap<>();
        for (int i = 0; i < 101; i++){
            path.put(i, new ArrayList<>());
        }

        while (!queue.isEmpty()){
            int i = queue.poll();
            List<Integer> pList = path.get(i);
            pList.add(i);
            for (int j = i + 1; j < i + 1; j++){
                if (j > 100){
                    System.out.println(-1);
                    System.exit(0);
                }
                else if (map.keySet().contains(j)){
                    j = map.get(j);
                }
                else if (!path.keySet().contains(j) || path.get(j).size() > pList.size()){
                    queue.add(j);
                    path.put(j, pList);
                }
            }
        }
        for (int i = 0; i < 101; i++) {
            System.out.println(i + " " + path.get(i));
        }
    }

    private static class QueueEntry{
        int v, dist;
        QueueEntry(int v, int dist){
            this.v = v;
            this.dist = dist;
        }
    }

    private static void leMinRolls(int[] moves){
        boolean[] visited = new boolean[100];
        Arrays.fill(visited, false);

        Queue<QueueEntry> queueEntries = new ArrayDeque<>();

        visited[0] = true;
        QueueEntry s = new QueueEntry(0, 0);
        queueEntries.add(s);

        QueueEntry entry = new QueueEntry(-1, -1);
        while (!queueEntries.isEmpty()){
            entry = queueEntries.peek();
            int v = entry.v;
            if (v == 99) break;

            queueEntries.poll();
            for (int j = v + 1; j <= (v+6) && j < 100; ++j){
                if (!visited[j]){
                    QueueEntry a = new QueueEntry(0, entry.dist + 1);
                    visited[j] = true;

                    if (moves[j] != -1)
                        a.v = moves[j];
                    else
                        a.v = j;
                    queueEntries.add(a);
                }
            }
        }
        System.out.println(entry.dist);
    }

//    private static void leBFS(HashMap<Integer, ArrayList<Integer>> boardGame){
//        int[] dist = new int[101];
//        Arrays.fill(dist, Integer.MAX_VALUE);
//        dist[0] = -1;
//        dist[1] = 0;
//
//        boolean[] visited = new boolean[101];
//        Arrays.fill(visited, false);
//        visited[0] = true;
//        visited[1] = true;
//
//        Queue<Integer> queue = new ArrayDeque<>();
//        queue.add(1);
//
//        while (!queue.isEmpty()){
//            int v = queue.remove();
//            for (int w: boardGame.get(v)){
//                if (!visited[w]){
//                    dist[w] = dist[v] + 1;
//                    visited[w] = true;
//                    queue.add(w);
//                }
//            }
//        }
//        if (dist[100] == Integer.MAX_VALUE){
//            System.out.println(-1);
//        }
//        else{
//            System.out.println(dist[100]);
//        }
//    }

//    private static void addEdge(HashMap<Integer, ArrayList<Integer>> boardGame, int[] edge){
//        for (int i = 1; i < 100; i++){
//            ArrayList<Integer> adjacent = boardGame.get(i);
//            if (adjacent.contains(edge[0])){
//                adjacent.remove(adjacent.indexOf(edge[0]));
//                adjacent.add(edge[1]);
//                boardGame.put(i, adjacent);
//            }
//        }
//
//
////        ArrayList<Integer> adjacent = boardGame.get(edge[0]);
////        adjacent.add(edge[1]);
////        boardGame.put(edge[0], adjacent);
//    }
//
//    private static HashMap<Integer, ArrayList<Integer>> getBoardGame(){
//        HashMap<Integer, ArrayList<Integer>> boardGame = new HashMap<>();
//        for (int j = 1; j < 95; j++){
//            for (int k = j + 1; k <= j + 6; k++){
//                ArrayList<Integer> adjacencies = new ArrayList<>();
//                adjacencies.add(k);
//                boardGame.put(j, adjacencies);
//            }
//        }
//        ArrayList<Integer> ninetyFive = new ArrayList<>(Arrays.asList(96, 97, 98, 99, 100));
//        ArrayList<Integer> ninetySix = new ArrayList<>(Arrays.asList(97, 98, 99, 100));
//        ArrayList<Integer> ninetySeven = new ArrayList<>(Arrays.asList(98, 99, 100));
//        ArrayList<Integer> ninetyEight = new ArrayList<>(Arrays.asList(99, 100));
//        ArrayList<Integer> ninetyNine = new ArrayList<>(Arrays.asList(100));
//        boardGame.put(95, ninetyFive);
//        boardGame.put(96, ninetySix);
//        boardGame.put(97, ninetySeven);
//        boardGame.put(98, ninetyEight);
//        boardGame.put(99, ninetyNine);
//        boardGame.put(100, new ArrayList<>());
//        return boardGame;
//    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }
}
