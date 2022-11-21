package programmers.etc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 행렬_테두리_회전하기_Remind {
    public static void main(String[] args) {
        int rows = 6;
        int columns = 6;
        int[][] queries = {
            {2, 2, 5, 4},
            {3, 3, 6, 6},
            {5, 1, 6, 3}};

        System.out.println(Arrays.toString(new Solution4().solution(rows, columns, queries)));
    }
}

class Solution4 {

    static int[][] map;

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer;
        List<Integer> minNums = new ArrayList<>();
        map = new int[rows][columns];

        // 초기 Map 셋팅
        int mapCount = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = mapCount;
                mapCount++;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            minNums.add(spin(queries[i]));
        }

        System.out.println("Map 최종 결과");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        answer = new int[minNums.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = minNums.get(i);
        }

        return answer;
    }

    private static int spin(int[] query) {
        int x1 = query[0] - 1; // 1
        int y1 = query[1] - 1; // 1
        int x2 = query[2] - 1; // 4
        int y2 = query[3] - 1; // 3 -> map[1][1] ~ map[4][3]
        int stock = map[x1][y1];
        int min = Integer.MAX_VALUE;

        // 왼쪽 세로변 시계방향 회전
        for (int i = x1; i < x2; i++) {
            map[i][y1] = map[i + 1][y1];
            min = Math.min(map[i + 1][y1], min);
        }

        // 아래쪽 가로변 시계방향 회전
        for (int i = y1; i < y2; i++) {
            map[x2][i] = map[x2][i + 1];
            min = Math.min(map[x2][i + 1], min);
        }

        // 오른쪽 세로변 시계방향 회전
        for (int i = x2; i > x1; i--) {
            map[i][y2] = map[i - 1][y2];
            min = Math.min(map[i - 1][y2], min);
        }

        // 위쪽 가로변 시계방향 회전
        for (int i = y2; i > y1; i--) {
            map[x1][i] = map[x1][i - 1];
            min = Math.min(map[x1][i - 1], min);
        }

        map[x1][y1 + 1] = stock;
        min = Math.min(map[x1][y1 + 1], min);

        return min;
    }
}


// (x1, y1, x2, y2) 테두리를 시계 방향으로 회전시킨다.
// row, column 은 행열 크기고 (0,0) 부터 내부 원소가 1씩 증가한다.
// ex) {2, 2, 5, 4} -> (1,1) ~ (4,3) 의 테두리를 시계 방향으로 회전시킨다.
// 첫 회전하는 라인을 정했다면 빈 곳을 채워주는 식으로 진행해야한다. 아무 라인을 막 회전하면 안된다.