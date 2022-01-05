package baekjoonbronze.implement;

import java.io.*;

public class BeakJoon1157 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] arr = new int[26];

        for (int i = 0; i < str.length(); i++) {
            if ('a' <= str.charAt(i) && str.charAt(i) <= 'z') {
                arr[str.charAt(i)-'a']++;
            }

            else if ('A' <= str.charAt(i) && str.charAt(i) <= 'Z') {
                arr[str.charAt(i)-'A']++;
            }
        }

        int max = 0;
        char result = ' ';

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                result = (char)(i+'A');

            } else if (arr[i] == max) {
                result = '?';
            }
        }

        System.out.println(result);
    }
}
