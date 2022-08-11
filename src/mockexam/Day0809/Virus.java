package mockexam.Day0809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Virus {

    static int node;
    static int edge;
    static int[][] arr;
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        node = Integer.parseInt(br.readLine());
        edge = Integer.parseInt(br.readLine());

        arr = new int[node + 1][node + 1];
        visited = new boolean[node + 1];

        // 인접 행렬을 사용해 풀이하기 때문에 이차원 배열 초기화
        for (int i = 0; i < edge; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        // 1번 Node 부터 탐색 시작
        DFS(1);
        System.out.println(answer - 1);
    }

    private static void DFS(int visitNode) {
        // 방문 표시 후 해당 컴퓨터 감염처리
        visited[visitNode] = true;
        answer ++;

        // 지금 방문한 노드와 연결된 다른 인접 노드를 찾기 위해 노드 개수만큼 반목
        for (int i = 0; i < node; i++) {

            // 현재 방문한 노드와 연결된 노드인가 ?
            // 인접행렬 그래프에서는 행을 기준으로 열이 1이라면 연결되어있다고 간주한다.
            // 즉, arr[1][2] == 1 이라고 한다면 1번 노드와 2번 노드는 연결되어있는 것
            if (arr[visitNode][i] == 1 && !visited[i]) {

                // 만약 현재 방문한 노드와 연결된 노드라면 i번 노드를 감염처리한다.
                DFS(i);
            }
        }
    }
}

// 무방향 그래프 생각해서 풀이하자.
/*
* 총 노드 개수 (7) / 간선 갯수 (6)
* (1,2)
* (2,3)
* (1,5)
* (5,2)
* (5,6)
* (4,7)
*
* */