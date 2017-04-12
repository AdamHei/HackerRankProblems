package Contests.WeekOfCode31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class ZeroOneGame {
    public static void main(String[] args) throws IOException {
        ZeroOneGame obj = new ZeroOneGame();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cases = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < cases; i++) {
            br.readLine();
            List<Integer> list = obj.toList(br.readLine().split(" "));

            int howManyMoves = obj.myBestCountMoves(list);
            System.out.println(howManyMoves % 2 == 0 ? "Bob" : "Alice");
        }
    }

    private int myBestCountMoves(List<Integer> listBoard) {
        MyLinkedList gameBoard = new MyLinkedList(listBoard);
        int count = 0;

        MyLinkedList.Node current = gameBoard.head;

        while (current.next != null) {
            if (current.previous != null && current.previous.element == 0 && current.next.element == 0) {
                MyLinkedList.Node prev = current.previous;
                MyLinkedList.Node next = current.next;

                prev.next = next;
                next.previous = prev;
                current = prev;
                count++;
            } else {
                current = current.next;
            }
        }

        return count;
    }

    private List<Integer> toList(String[] strArr) {
        List<Integer> list = new ArrayList<>();
        for (String aStrArr : strArr) {
            list.add(Integer.parseInt(aStrArr));
        }
        return list;
    }

    public class MyLinkedList {
        Node head;
        int size;

        private class Node {
            Node(int element) {
                this.element = element;
            }

            int element;
            Node next;
            Node previous;
        }

        MyLinkedList(List<Integer> list) {
            size = list.size();
            head = new Node(list.get(0));
            head.previous = null;
            Node current = head;

            for (int i = 1; i < list.size(); i++) {
                Node next = new Node(list.get(i));
                current.next = next;
                next.previous = current;

                current = next;
            }
        }
    }
}
