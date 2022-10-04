package mockexam.Day1004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 경로_찾기 {

    static int n;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        // 1. 맵 만들기
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // i 에서 j 까지 갈 수 있는 간선이 있는가 ?
        // i 에서 k 를 거쳐 k 까지 갈 수 있는 간선이 있는가 ?
        // 1중 for (거쳐가는 노드 k), 2중 for (시작 노드 i), 3중 for (끝 노드 j)
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][k] == 1 && map[k][j] == 1) {
                        map[i][j] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j] + " ");
            }

            System.out.println();
        }
    }
}

// 모든 정점 i,j 에 대해 i 에서 j 로 가는 경로가 있는지 없는지 구하는 프로그램을 작성해라.