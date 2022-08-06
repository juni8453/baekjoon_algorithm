package study.section7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Section0701 {

    static int n;
    static int result = 0;
    static List<Integer> answerNumbers = new ArrayList<>();

    private static void DFS(int result) {
        // DFS 탈출 조건
        if (result == n) {
            return;

        // DFS 실행 계획
        } else {
            result += 1;
            answerNumbers.add(result);
            DFS(result);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        DFS(result);
        answerNumbers.forEach(number -> System.out.print(number + " "));
    }
}

// 자연수 n 이 주어졌을 떄, 재귀를 이용해 1 부터 N 까지 출력하는 프로그램을 작성해라.
// Input = 3 -> Output 1 2 3
