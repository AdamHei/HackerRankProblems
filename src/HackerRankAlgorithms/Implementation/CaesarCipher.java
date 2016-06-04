package HackerRankAlgorithms.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Adam on 5/17/2016.
 */
public class CaesarCipher {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String toEncrypt = br.readLine();
        Integer k = Integer.parseInt(br.readLine());
        encrypt(toEncrypt, k);
    }

    private static void encrypt(String s, int k){
        char[] arr = s.toCharArray();
        k %= 26;

        for (int i = 0; i < arr.length; i++){
            if (90 >= arr[i] && arr[i] >= 65){
                if (k > (90 - arr[i])){
                    arr[i] = (char) (64 + k - (90 - arr[i]));
                }
                else{
                    arr[i] += k;
                }
            }
            else if (97 <= arr[i] && arr[i] <= 122){
                if (k > (122 - arr[i])){
                    arr[i] = (char) (96 + k - (122 - arr[i]));
                }
                else{
                    arr[i] += k;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char c: arr){
            stringBuilder.append(c);
        }
        System.out.println(stringBuilder.toString());
    }
}
