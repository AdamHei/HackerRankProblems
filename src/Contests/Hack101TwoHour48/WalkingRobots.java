package Contests.Hack101TwoHour48;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WalkingRobots {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int queries = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < queries; i++) {
            char[] robots = br.readLine().toCharArray();

            int deadCount = 0, rightCount = 0;
            int collisions = 0;

            int index = 0;
            while (index < robots.length && robots[index] == 'l'){
                index++;
            }

            while (index < robots.length){
                char robot = robots[index];
                if (robot == 'r'){
                    rightCount += 1;
                }
                else if (robot == 'd'){
                    if (rightCount > 0){
                        collisions += rightCount;
                        rightCount = 0;
                    }
                    deadCount += 1;
                }
                else if (robot == 'l'){
                    if (rightCount > 0){
                        collisions += 2;
                        rightCount -= 1;
                        collisions += rightCount;
                        rightCount = 0;
                        deadCount += 1;
                    }
                    else if (deadCount > 0){
                        collisions += 1;
                    }
                }

                index++;
            }

            System.out.println(collisions);
        }
    }
}
