package programmers.dfs;

public class 네트워크_Remind {
    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 1}
        };

        System.out.println(new Solution7().solution(n, computers));
    }
}

class Solution7 {

    static int nodeIdx;
    static int answer;
    static boolean[] checked;
    static int[][] map;

    public int solution(int n, int[][] computers) {
        nodeIdx = n;
        map = computers;
        checked = new boolean[nodeIdx];

        for (int nowComputer = 0; nowComputer < nodeIdx; nowComputer++) {
            // 방문하지 않은 노드를 방문하자.
            if (!checked[nowComputer]) {
                answer++;
                checkNetWorkForComputer(nowComputer);
            }
        }

        return answer;
    }

    private static void checkNetWorkForComputer(int nowComputer) {
        // 해당 노드 방문체크 실시
        checked[nowComputer] = true;

        for (int connectedComputer = 0; connectedComputer < nodeIdx; connectedComputer++) {
            // 현재 노드와 연결된 노드를 찾은 경우
            if (!checked[connectedComputer] && map[nowComputer][connectedComputer] == 1) {
                checkNetWorkForComputer(connectedComputer);
            }
        }
    }
}

// 간선 갯수가 명시되어있지 않아서 인접 행렬, 리스트로는 바로 접근할 수 없다.
// i번 컴퓨터와 j번 컴퓨터가 연결되어 있으면 computers[i][j]를 1로 표현한다.
// 네트워크 유형은 대게 DFS 로 풀이할 수 있다.
