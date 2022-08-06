package study.section7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Section0703 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = DFS(n);
        System.out.println(answer);
    }

    private static int DFS(int n) {
        // 탈출 조건 설정
        if (n == 1) {
            return 1;

        // 재귀 호출 부분;
        } else {
            return n * DFS(n - 1);
        }
    }
}

// 자연수 n 이 주어지면 재귀를 이용해 팩토리얼 값을 구해라.
// Input 5 -> 5*4*3*2*1 = 120
