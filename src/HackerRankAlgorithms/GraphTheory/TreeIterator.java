package HackerRankAlgorithms.GraphTheory;

import java.util.ArrayDeque;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * Created by Adam on 6/8/2016.
 */
class TreeIterator {
    private Tree.Node<Integer> next;

    private Queue<Tree.Node<Integer>> queue;

    TreeIterator(Tree.Node<Integer> root){
        next = root;
        queue = new ArrayDeque<>();
        if (next == null) return;
        while (next.children != null && next.children.size() > 0){
            next = next.children.get(0);
        }
    }

    boolean hasNext(){
        return next != null;
    }

    Tree.Node<Integer> next(){
        if (!hasNext()) throw new NoSuchElementException();
        Tree.Node<Integer> r = next;

        if (queue.size() > 0){
            next = queue.poll();
        }
        else if (next.parent == null) {
            next = null;
        }
        else{
            next = next.parent;
            queue.addAll(next.children);
        }
        return r;

//        if (next.children != null && next.children.size() > 0){
//            next = next.children.get(next.children.size() - 1);
//            while (next.children != null && next.children.size() > 0){
//                next = next.children.get(0);
//            }
//            return r;
//        }
//        else while (true){
//            if (next.parent == null){
//                next = null;
//                return r;
//            }
//            if (next.parent.children.get(0) == next){
//                next = next.parent;
//                return r;
//            }
//            next = next.parent;
//        }
    }
}
