package study.section7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 모든 경로의 가짓수를 출력하는 문제 (인접 행렬)
// 모든 배열은 +1 의 길이를 가지도록 설정한다. 노드가 1번부터 시작하니까 맞춰주기 위함
public class AdjacencyMatrix {
    static int answer = 0;
    static int nodeIdx;
    static int edge;
    static int[] checkArr;
    static int[][] matrix;

    // v = 출발 노드번호
    public static void DFS(int v) {
        if (v == nodeIdx) {
            answer++;
        } else {
            for (int i = 1; i <= nodeIdx; i++) {
                if (matrix[v][i] == 1 && checkArr[i] == 0) {
                    checkArr[i] = 1;
                    DFS(i);
                    checkArr[i] = 0; // 다시 돌아올 때 꼭 체크를 풀어줘야한다.
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        nodeIdx = Integer.parseInt(st.nextToken()); // 노드 번호
        edge = Integer.parseInt(st.nextToken()); // 간선 갯수
        checkArr = new int[nodeIdx + 1]; // 방문체크 배열
        matrix = new int[nodeIdx + 1][nodeIdx + 1]; // 인접행렬 그래프

        for (int i = 0; i < edge; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            matrix[a][b] = 1;
        }
        checkArr[1] = 1;
        DFS(1); // 1번 노드부터 출발
        System.out.println(answer);
    }
}
