package Misc;

import java.util.ArrayDeque;
import java.util.Optional;
import java.util.Queue;

/**
 * Stack implementation using a single Queue
 */
class MyStack {
    private Queue<Integer> stack;

    MyStack(){
        this.stack = new ArrayDeque<>();
    }

    void printState(){
        for (int i: this.stack){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    Optional<Integer> pop(){
        if (this.stack.size() > 0){
            return Optional.of(this.stack.poll());
        }
        return Optional.empty();
    }

    boolean isEmpty(){
        return this.stack.size() == 0;
    }

    void push(int i){
        reverseQueue();
        this.stack.add(i);
        reverseQueue();
    }

    private void reverseQueue(){
        if (this.stack.size() > 0){
            int temp = this.stack.poll();
            reverseQueue();
            this.stack.add(temp);
        }
    }
}