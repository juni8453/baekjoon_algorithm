package programmers.brute_force;

public class 피로도 {
    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
        System.out.println(new Solution4().solution(k, dungeons));
    }
}

class Solution4 {
    static int answer;
    static int K;
    static int node;
    static int count;
    static int[] checked;
    static int[][] Dungeons;

    public int solution(int k, int[][] dungeons) {
        Dungeons = dungeons;
        K = k;
        node = dungeons.length;
        checked = new int[node];
        count = 0;

        DFS(0, K);

        return answer;
    }

    // 던전을 모두 돌 수 없을지도 모르기 때문에 모든 던전(노드) 갯수만큼 꼭 다 돌아야 정답인지는 알 수 없으므로
    // if-else 탈출구문을 따로 작성하지 않았다.
    private static void DFS(int depth, int k) {
        for (int i = 0; i < node; i++) {
            if (checked[i] == 0 && k >= Dungeons[i][0]) {
                checked[i] = 1;
                DFS(depth + 1, k - Dungeons[i][1]);
                checked[i] = 0;
            }
        }

        answer = Math.max(answer, depth);
    }
}
