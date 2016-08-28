package Contests;

import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Adam on 8/28/2016.
 */
public class Abbreviation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine().trim());

        for (int i = 1; i <= cases; i++){
            String a = br.readLine();
            String b = br.readLine();
            int k = 0;
            boolean cantDoItJerry = false;
            boolean lowerToDelete = false;
            boolean lowerToKeep = false;
            for (char c: a.toCharArray()){
                if (k >= b.length() && Character.isUpperCase(c)) cantDoItJerry = true;
                else if (k < b.length()){
                    char bChar = b.charAt(k);
                    if (Character.toLowerCase(bChar) != Character.toLowerCase(c)){
                        if (Character.isUpperCase(c)){
                            cantDoItJerry = true;
                        }
                        else {
                            lowerToDelete = true;
                        }
                    }
                    else {
                        if (Character.isLowerCase(bChar) && Character.isUpperCase(c)){
                            cantDoItJerry = true;
                        }
                        else if (Character.isLowerCase(bChar)){
                            lowerToKeep = true;
                        }
                        k++;
                    }
                }
            }
            if (cantDoItJerry || (lowerToDelete && lowerToKeep)){
                System.out.println("NO");
            }
            else {
                System.out.println("YES");
            }
        }
    }
}
