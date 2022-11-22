package programmers.graph;

public class 순위_Review {
    public static void main(String[] args) {
        int n = 5;
        int[][] result = {
            {4, 3},
            {4, 2},
            {3, 2},
            {1, 2},
            {2, 5}
        };

        System.out.println(new Solution2_1().solution(n, result));
    }
}

class Solution2_1 {

    static int[][] floyd;

    public int solution(int n, int[][] arr) {
        int answer = 0;
        floyd = new int[n][n];

        for (int i = 0; i < arr.length; i++) {
            int aPerson = arr[i][0];
            int bPerson = arr[i][1];

            floyd[aPerson - 1][bPerson - 1] = 1; // 행 사람이 열 사람을 이겼다라는 의미
        }

        for (int i = 0; i < n; i++) { // 중간
            for (int j = 0; j < n; j++) { // 시작
                for (int k = 0; k < n; k++) { // 끝

                    // 시작 ~ 중간, 중간 ~ 끝 을 모두 판단할 수 있는 경우 확실하게 등수를 결정지을 수 있다.
                    if (floyd[j][i] == 1 && floyd[i][k] == 1) {
                        floyd[j][k] = 1;
                    }
                }
            }
        }

        System.out.println("======");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(floyd[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("======");

        for (int i = 0; i < n; i++) {
            int result = 0;

            for (int j = 0; j < n; j++) {
                if (floyd[i][j] != 0 || floyd[j][i] != 0) { // 양 선수 중 누가 이기는지 확실히 판단 가능한 경우
                    result++;
                }
            }

            if (result == n - 1) {
                answer++;
            }
        }


        return answer;
    }
}

// 1 ~ n 명의 선수가 있고 1:1 대결방식을 통해 순위를 매긴다.
// [A, B] 라면 A 선수가 B 선수를 이긴다라는 의미이다.
// 정확하게 순위를 매길 수 있는 선수의 수를 return 하는 프로그램을 작성해라.

// 확실하게 알 수 있는 방법이 없기 떄문에 플로이드 와샬 알고리즘을 통해 각각 대조하면서 알아내야 한다.

/**
     0 1 2 3 4
     - - - - -
 0 | 0 1 0 0 0
 1 | 0 0 0 0 1
 2 | 0 1 0 0 0
 3 | 0 1 1 0 0
 4 | 0 0 0 0 0
 */
