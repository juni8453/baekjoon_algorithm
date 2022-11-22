package programmers.graph;

public class 순위 {
    public static void main(String[] args) {
        int n = 5;
        int[][] arr = {
            {4, 3},
            {4, 2},
            {3, 2},
            {1, 2},
            {2, 5}
        };

        System.out.println(new Solution2().solution(n, arr));
    }
}

class Solution2 {
    static int nodeIdx;
    static int edge;
    static int[][] map;

    public int solution(int n, int[][] arr) {
        nodeIdx = n;
        edge = arr.length;
        int answer = 0;
        int[][] map = new int[nodeIdx + 1][nodeIdx + 1];

        for (int i = 0; i < edge; i++) {
            int aPerson = arr[i][0];
            int bPerson = arr[i][1];
            map[aPerson][bPerson] = 1; // aPerson 이 bPerson 을 이겼을 때 기록
//            map[bPerson][aPerson] = -1; // aPerson 이 bPerson 한테 졌을 때 기록
        }

        for (int i = 1; i <= nodeIdx; i++) { // 거치는 정점
            for (int j = 1; j <= nodeIdx; j++) { // 시작 정점
                for (int k = 1; k <= nodeIdx; k++) { // 도착 정점

                    // (시작 정점, 중간 정점 == 1) 이며 (중간 정점, 도착 정점 == 1) 인 경우 확실하게 등수를 판단할 수 있으므로
                    // (시작 정점, 도착 정점) 을 1로 셋팅한다.
                    if (map[j][i] == 1 && map[i][k] == 1) {
                        map[j][k] = 1;
                    }
                }
            }

        }

        for (int i = 1; i <= nodeIdx; i++) {
            int result = 0;

            // map[i][j] 또는 map[j][i] 가 0 이 아니라면 두 선수의 실력을 가늠할 수 있다. 일단 체크
            // ex) 1행 2열 = 1 -> 1번 선수가 2번 선수를 이겼다.
            for (int j = 1; j <= nodeIdx; j++) {
                if (map[i][j] != 0 || map[j][i] != 0) {
                    result++;
                }
            }

            // 한 선수가 나머지 선수와의 실력을 가늠할 수 있다는 것은 모든 선수 - 1 만큼 체크가 되어있다는 의미이다.
            // 즉, 확실하게 등수를 가릴 수 있다는 뜻.
            if (result == nodeIdx - 1) {
                answer++;
            }
        }

        return answer;
    }
}

// 정확하게 순위를 매길 수 있는 선수의 수를 return 해라.
// (a, b) -> a 선수가 b 선수를 이겼다는 의미.
// 플로이드 와샬 알고리즘으로 풀이할 수 있다.
//
//        st = new StringTokenizer(br.readLine());
//        int X = Integer.parseInt(st.nextToken());
//        int K = Integer.parseInt(st.nextToken());
//
//        // k <= N 또는 k < N + 1 가능
//        for (int k = 1; k <= N; k++) {
//            for (int i = 1; i <= N; i++) {
//                for (int j = 1; j <= N; j++) {
//                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
//                }
//            }
//        }
