package Contests.WeekOfCode31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class ZeroOneGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cases = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < cases; i++) {
            br.readLine();
            List<Integer> list = toList(br.readLine().split(" "));

            int howManyMoves = newCountMoves(list);
            System.out.println(howManyMoves % 2 == 0 ? "Bob" : "Alice");
        }
    }

    private static int newCountMoves(List<Integer> gameBoard){
        int count = 0;
        for (int i = 1; i < gameBoard.size() - 1; i++) {
            if (gameBoard.get(i - 1) == 0 && gameBoard.get(i + 1) == 0){
                gameBoard.remove(i);
                if (i > 1){
                    i -= 2;
                }
                else {
                    i--;
                }
                count++;
            }
        }
        return count;
    }

    private static int countMoves(List<Integer> gameBoard) {
        int count = 0;
        boolean removed = findAndRemove(gameBoard);

        while (removed) {
            count++;
            removed = findAndRemove(gameBoard);
        }

        return count;
    }

    private static boolean findAndRemove(List<Integer> list) {
        for (int i = 1; i < list.size() - 1; i++) {
            if (list.get(i - 1) == 0 && list.get(i + 1) == 0) {
                list.remove(i);
                return true;
            }
        }
        return false;
    }

    private static List<Integer> toList(String[] strArr) {
        List<Integer> list = new ArrayList<>();
        for (String aStrArr : strArr) {
            list.add(Integer.parseInt(aStrArr));
        }
        return list;
    }
}
