package Contests.BookingWomenInTech;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class EmailsEverywhere {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int queries = Integer.parseInt(br.readLine().trim());

        PriorityQueue<EmailObj> buffer = new PriorityQueue<>();
        for (int i = 0; i < queries; i++) {
            String[] query = br.readLine().split(" ");
            if (query[0].equals("store")) {
                String content = query[1];
                int priority = Integer.parseInt(query[2]);
                EmailObj emailObj = new EmailObj(content, priority, i);
                buffer.add(emailObj);
            }
            else {
                if (buffer.size() == 0){
                    System.out.println(-1);
                }
                else {
                    System.out.println(buffer.poll().content);
                }
            }
        }
    }

    private static class EmailObj implements Comparable<EmailObj> {
        String content;
        int priority;
        int timeReceived;

        EmailObj(String c, int p, int t) {
            content = c;
            priority = p;
            timeReceived = t;
        }

        @Override
        public int compareTo(EmailsEverywhere.EmailObj o) {
            if (this.priority > o.priority) return -1;
            if (this.priority < o.priority) return 1;
            if (this.timeReceived < o.timeReceived) return -1;
            return 1;
        }
    }

    private static int[] toIntArray(String[] strArr) {
        int[] arr = new int[strArr.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }
        return arr;
    }
}
