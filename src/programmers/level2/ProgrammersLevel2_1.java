package programmers.level2;

import java.io.IOException;
import java.util.Scanner;

public class ProgrammersLevel2_1 {
    static int node;
    static int answer;
    static boolean[] check;
    static int[][] computers;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        node = sc.nextInt();
        computers = new int[node + 1][node + 1];
        check = new boolean[node + 1];

        for (int i = 1; i <= node; i++) {
            for (int j = 1; j <= node; j++) {
                computers[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i <= node; i++) {
            if (!check[i]) {
                answer ++;
                DFS(i);
            }
        }

        System.out.println(answer);
    }

    private static void DFS(int depth) {
        check[depth] = true;

        for (int i = 1; i <= node; i++) {
            if (computers[depth][i] == 1 && !check[i]) {
                check[i] = true;
                DFS(i);
            }
        }
    }
}

// 컴퓨터 개수 n, 연결 정보를 담은 2차원 배열 computers
// 네트워크의 갯수는 ?

// n =3
//    1 2 3
// 1 [1 1 0]
// 2 [1 1 0]
// 3 [0 0 1]


