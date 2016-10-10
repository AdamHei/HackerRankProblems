package HackerRankAlgorithms.CrackingTheCodingInterview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by Adam on 9/28/2016.
 */
public class BalancedBrackets {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine().trim());

        Map<String, String> map = new HashMap<>();
        map.put("{", "}");
        map.put("(", ")");
        map.put("[", "]");
        Stack<String> stack = new Stack<>();
        for (int i = 1; i <= cases; i++){
            String[] brackets = br.readLine().split("");
            for (String bracket : brackets) {
                if (stack.size() == 0) {
                    stack.push(bracket);
                } else if (bracket.equals(map.get(stack.peek()))) {
                    stack.pop();
                } else {
                    stack.push(bracket);
                }
            }
            System.out.println(stack.size() == 0 ? "YES" : "NO");
            stack.clear();
        }
    }
}
