package baekjoonbronze.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj10870 {
    public static int DFS(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return DFS(n - 1) + DFS(n - 2);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = DFS(n);
        System.out.println(answer);
    }
}
