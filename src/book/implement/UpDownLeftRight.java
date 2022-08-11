package book.implement;

import java.util.Arrays;

public class UpDownLeftRight {
    public static void main(String[] args) {
        int n = 5;
        char[] movePlan = {'R', 'R', 'R', 'U', 'D', 'D'};
        int[] solution = new Solution().solution(n, movePlan);

        Arrays.stream(solution).forEach(i -> System.out.print(i + " "));
    }

    static class Solution {
        public int[] solution(int n, char[] movePlan) {
            int[] dx = {0, 0, 1, -1};
            int[] dy = {1, -1, 0, 0};
            int nx = 0;
            int ny = 0; // 다음 좌표 초기화
            int x = 1;
            int y = 1; // 최초 좌표는 1,1 이기에 이렇게 초기화
            char[] moveType = {'R', 'L', 'D', 'U'};

            for (int i = 0; i < movePlan.length; i++) {
                for (int j = 0; j < 4; j++) {
                    if (movePlan[i] == moveType[j]) {
                        nx = x + dx[j];
                        ny = y + dy[j];
                    }

                    if (nx < 1 || ny < 1 || nx > n || ny > n) {
                        continue; // (j 반복문 무시 즉, 움직이지 않는다.)
                    }

                    x = nx;
                    y = ny;
                }
            }

            int[] answer = {x, y};
            return answer;
        }
    }
}

// 상하좌우
/*
출발지점은 1,1 고정
이동할 수 있는 맵 안쪽이 아니라면 무시
moveArr 만큼 이동

방향 벡터 (동서남북 기준)
행 dx = {0, 0, 1, -1}
열 dy = {1, -1, 0, 0}
nx(다음의 행 좌표) = x(현재의 행 좌표) + dx[i]
ny(다음의 열 좌표) = y(현재의 열 좌표) + dx[i]

1,1 -> (R) -> 2,1 -> (R) -> 3,1 -> (R) -> 4,1 -> (U / 1보다 작은 y축(열)은 없으므로 무시)
-> (D) -> 4,2 (D) -> 4,3 (종료)

* R R R U D D
* 3 4 출력
* */
