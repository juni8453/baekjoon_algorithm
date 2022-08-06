package mockexam.Day0804;

import java.io.IOException;

public class TargetNumber {

    static int target = 3;
    static int answer = 0;
    static int[] arr = {1, 1, 1, 1, 1};

    public static void main(String[] args) throws IOException {

        DFS(0, 0);

        System.out.println(answer);
    }

    private static void DFS(int depth, int sum) {
        // 탈출구문 작성
        if (depth == arr.length) {
            if (sum == target) {
                answer ++;
            }
            return;
        }

        // 재귀 호출부분 작성
        // 2가지의 경우의 수가 있으니 DFS 호출 부분은 2개
        else {
            DFS(depth + 1, sum + arr[depth]);
            DFS(depth + 1, sum - arr[depth]);
        }
    }
}