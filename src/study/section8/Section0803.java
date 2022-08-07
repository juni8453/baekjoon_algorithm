package study.section8;

import java.io.IOException;
import java.util.Scanner;

public class Section0803 {
    static int issueCount = 0; // 문제 갯수
    static int timeout = 0;    // 제한 시간
    static int answer = 0;     // 이전 노드의 sum 과 비교할 수 있는 값
    static int[] scoreArr;
    static int[] timeArr;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        issueCount = sc.nextInt();
        timeout = sc.nextInt();

        scoreArr = new int[issueCount];
        timeArr = new int[issueCount];

        for (int i = 0; i < issueCount; i++) {
            scoreArr[i] = sc.nextInt();
            timeArr[i] = sc.nextInt();
        }

        DFS(0, 0, 0);
        System.out.println(answer);
    }

    private static void DFS(int depth, int sum, int totalTime) {
        if (totalTime > timeout) {
            return;
        }

        if (depth == issueCount) {
            answer = Math.max(sum, answer);
        } else {
            DFS(depth + 1, sum + scoreArr[depth], totalTime + timeArr[depth]);
            DFS(depth + 1, sum, totalTime);
        }
    }
}
