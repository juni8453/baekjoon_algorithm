package study.section5;

import java.util.Scanner;
import java.util.Stack;

public class Section0503 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] board = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int M = sc.nextInt();
        int[] moves = new int[M];

        for (int i = 0; i < M; i++) {
            moves[i] = sc.nextInt();
        }

        int answer = Section0503.solution(board, moves);
        System.out.println(answer);
    }

    // m = 크레인 움직이는 횟수, board = 보드판, moves = 크레인이 순서대로 움직이는 위치
    // 크레인이 인형을 뽑으면 맨 위는 0으로 바뀌어야 한다.
    private static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> bucket = new Stack<>();

        // 크레인 움직임 하나하나 체크하면서 board 탐색
        for (int move : moves) {
            for (int i = 0; i < board.length; i++) {

                // 열은 고정하고 행이 움직이도록 해서 세로로 탐색
                if (board[i][move - 1] != 0) {
                    int top = board[i][move - 1];

                    // 빼냈으니까 0으로 바꿔줌
                    board[i][move - 1] = 0;

                    // 같은 인형은 터뜨려야 함.
                    if (!bucket.isEmpty() && top == bucket.peek()) {
                        answer += 2;
                        bucket.pop();

                    } else {
                        bucket.push(top);
                    }

                    // 해당 열을 탐색하고 또 인형을 꺼내면 안되니까 멈춰주기.
                    break;
                }
            }
        }

        return answer;
    }
}

// 격자의 상태가 담긴 2차원 배열 board
// 인형을 집기 위해 크레인을 작동시킨 위치가 담긴 배열 moves 가 변수로 주어진다.
// 크레인을 모두 작동시킨 후 터트려져 사라진 인형의 개수를 구해라.

/*
* N = 5 (N * N = 25 보드의 크기)
*
* 0 0 0 0 0
* 0 0 1 0 3
* 0 2 5 0 1
* 4 2 4 4 2
* 3 5 1 3 1
*
* M = 8 (moves 배열의 길이 / 크레인이 움직이는 횟수)
*
* 1 5 3 5 1 2 1 4 (크레인이 순서대로 움직이는 위치)
* */