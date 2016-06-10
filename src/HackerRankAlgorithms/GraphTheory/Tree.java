package HackerRankAlgorithms.GraphTheory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adam on 6/8/2016.
 */
class Tree<Integer> {
    Node<Integer> root;

    Tree(Integer rootData){
        root = new Node<>(rootData, null);
        root.children = new ArrayList<>();
    }

    static class Node<Integer>{
        Node(Integer integer, Node<Integer> parent){
            this.data = integer;
            this.children = new ArrayList<>();
            this.parent = parent;
            this.marked = false;
        }

        boolean marked;
        Integer data;
        Node<Integer> parent;
        List<Node<Integer>> children;
    }
}
