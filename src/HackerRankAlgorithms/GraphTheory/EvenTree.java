package HackerRankAlgorithms.GraphTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Adam on 6/8/2016.
 */
public class EvenTree {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nodesAndEdges = toIntArray(br.readLine().split(" "));

        Map<Integer, Integer> childCount = new HashMap<>();
        int[] childToParent = new int[nodesAndEdges[0] + 1];

        for (int i = 1; i <= nodesAndEdges[1]; i++){
            int[] edge = toIntArray(br.readLine().split(" "));
            int child = edge[0];
            int parent = edge[1];
            childToParent[child] = parent;

            childCount.putIfAbsent(parent, 1);
            childCount.putIfAbsent(child, 1);

            int count = childCount.get(parent);
            childCount.put(parent, ++count);
        }

        int cuts = 0;
        for (int nodeIndex = childToParent.length - 1; nodeIndex > 1; nodeIndex--){
            if (childCount.get(nodeIndex) % 2 == 0){
                boolean hasEven = false;
                for (int i = childToParent.length - 1; i > 1; i--){
                    if (childToParent[i] == nodeIndex){
                        if (childCount.get(i) % 2 == 0){
                            hasEven = true;
                        }
                    }
                }
                if (!hasEven){
                    cuts++;
                    int parent = childToParent[nodeIndex];
                    childToParent[nodeIndex] = 0;
                    int count = childCount.get(parent);
                    childCount.put(parent, --count);
                }
            }
        }
        System.out.println(cuts);
    }

    private static int[] toIntArray(String[] arr){
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1){
            toReturn[i] = Integer.parseInt(arr[i]);
        }
        return toReturn;
    }

//    private static void traverse(Node<Integer> child){
//        child.children.forEach(EvenTree::traverse);
////        System.out.println(child.data);
//        if (!child.marked){
//            if (child.children.size() == 1 && !child.children.get(0).marked && child.children.get(0).children.size() == 0){
//                cuts++;
//                child.marked = true;
//                child.children.get(0).marked = true;
//            }
//            else if (child.children.size() == 2 && !child.children.get(0).marked && !child.children.get(1).marked){
//                if (child.children.get(0).children.size() == 0 && child.children.get(1).children.size() == 0){
//                    if (child.parent.parent != null && child.parent.children.size() == 1){
//                        cuts++;
//                        child.marked = true;
//                        child.children.get(0).marked = true;
//                        child.children.get(1).marked = true;
//                        child.parent.marked = true;
//                    }
//                }
//            }
//        }
//    }

//    private static class Tree<Integer> {
//        Node<Integer> root;
//
//        Tree(Integer rootData){
//            root = new Node<Integer>(rootData, null);
//            root.children = new ArrayList<>();
//        }
//    }
//
//    private static class Node<Integer>{
//        Node(Integer integer, Node<Integer> parent){
//            this.data = integer;
//            this.children = new ArrayList<>();
//            this.parent = parent;
//            this.marked = false;
//        }
//
//        boolean marked;
//        Integer data;
//        Node<Integer> parent;
//        List<Node<Integer>> children;
//    }
}
