package Stanford;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adam on 7/6/2016.
 */
class Heap {

    private List<Integer> heap;

    Heap(){
        heap = new ArrayList<>();
    }

    Heap(int[] arr){
        heap = new ArrayList<>();
        for (int i: arr){
            insert(i);
        }
    }

    boolean isEmpty(){
        return heap.size() == 0;
    }

    private void insert(int k){
        heap.add(k);
        int index = heap.size() - 1;

        int parent = index / 2;
        while (index > 0 && heap.get(parent) > k){
            swap(parent, index);
            index = parent;
            parent = index / 2;
        }
    }

    int extract() {
        if (heap.size() == 0){
            return -1;
        }
        if (heap.size() == 1){
            return heap.remove(0);
        }

        int toReturn = heap.get(0);
        swap(0, heap.size() - 1);
        heap.remove(heap.size() - 1);

        int index = 0;
        int minChildIndex = minChildIndex(index);
        while (minChildIndex != -1){
            swap(minChildIndex, index);
            index = minChildIndex;
            minChildIndex = minChildIndex(index);
        }

        return toReturn;
    }

    private int minChildIndex(int i){
        int bubbler = heap.get(i);
        boolean leftChild = 2 * i < heap.size();
        boolean rightChild = 2 * i + 1 < heap.size();

        if (leftChild && rightChild){
            if (bubbler <= heap.get(2 * i) && bubbler <= heap.get(2 * i + 1)){
                return -1;
            }
            int left = heap.get(2 * i);
            int right = heap.get(2 * i + 1);
            return left < right ? 2 * i : 2 * i + 1;
        }
        else if (leftChild){
            if (bubbler <= heap.get(2 * i)){
                return -1;
            }
            return 2 * i;
        }
        else{
            return -1;
        }
    }

    public void print(){
        int levels = (int) (Math.log(heap.size()) / Math.log(2)) + 1;

        for (int i = 1; i <= levels; i++){
            printXSpaces(2 * (levels - i));
            for (int j = (int) Math.pow(2, i - 1); j <= (int) Math.pow(2, i) - 1; j++){
                if (j <= heap.size()){
                    System.out.print(heap.get(j - 1) + "   ");
                }
            }
            if (i < levels){
                System.out.println();
                printXSpaces(2 * (levels - i) - 1);
                boolean left = false;
                int numSlashes = 2 * i;
                for (int k = 0; k < numSlashes; k++){
                    System.out.print((left = !left) ? "/" : "\\");
                    System.out.print(" ");
                }
                System.out.println();
            }
        }
    }

    private void printXSpaces(int x){
        for (int i = 0; i < x; i++){
            System.out.print(" ");
        }
    }

    private void swap(int i, int j){
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}
