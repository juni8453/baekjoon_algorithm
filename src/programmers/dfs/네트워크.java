package programmers.dfs;

public class 네트워크 {
    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 1}
        };

        System.out.println(new Solution3().solution(n, computers));
    }
}

class Solution3 {

    static int answer;
    static int nodeIdx;
    static boolean[] checked;

    public int solution(int n, int[][] computers) {
        nodeIdx = n;
        checked = new boolean[n];

        // 행을 기준으로 for 문 시작 -> 해당 행(컴퓨터, 노드) 를 방문했는지 확인
        for (int i = 0; i < n; i++) {
            if (!checked[i]) {
                answer++;
                DFS(i, computers);
            }
        }


        return answer;
    }

    private static void DFS(int node, int[][] computers) {
        checked[node] = true;

        // node (기준 행의 컴퓨터) 가 인자로 왔으니 해당 행의 열을 탐색
        for (int i = 0; i < nodeIdx; i++) {
            if (!checked[i] && computers[node][i] == 1) {
                DFS(i, computers);
            }
        }
    }
}

// 간선 갯수를 알 수 없으니 인접행렬, 리스트 말고 다른 방법을 사용해야한다.
// 이차원 배열이니 행을 기준으로 내려가며 1 값이 있는지 탐색한다.