package programmers.etc.dev_matching_pratice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 행렬_테두리_회전하기 {
    public static void main(String[] args) {
        int rows = 6;
        int column = 6;
        int[][] queries = {
            {2, 2, 5, 4},
            {3, 3, 6, 6},
            {5, 1, 6, 3}
        };

        int rows2 = 3;
        int column2 = 3;
        int[][] queries2 = {
            {1, 1, 2, 2},
            {1, 2, 2, 3},
            {2, 1, 3, 2},
            {2, 2, 3, 3}
        };

        System.out.println(Arrays.toString(new Solution2().solution(rows, column, queries)));
        System.out.println(Arrays.toString(new Solution2().solution(rows2, column2, queries2)));
    }
}

class Solution2 {
    static int sRows;
    static int sColumns;
    static int[][] sQueries;
    static int[][] map;
    static List<Integer> list = new ArrayList<>();

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer;
        sRows = rows;
        sColumns = columns;
        sQueries = queries;
        map = new int[sRows][sColumns];

        int mapCount = 1;
        // Map 초기화
        for (int i = 0; i < sRows; i++) {
            for (int j = 0; j < sColumns; j++) {
                map[i][j] = mapCount;
                mapCount++;
            }
        }

        for (int i = 0; i < sQueries.length; i++) {
            list.add(spin(sQueries[i]));
        }

        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

       return answer;
    }

    private static int spin(int[] query) {
        int x1 = query[0] - 1; // 2 -> 1
        int y1 = query[1] - 1; // 2 -> 1
        int x2 = query[2] - 1; // 5 -> 4
        int y2 = query[3] - 1; // 4 -> 3
        int stock = map[x1][y1];
        int min = (int) 1e9;

        for (int i = x1; i < x2; i++) {
            map[i][y1] = map[i + 1][y1];
            min = Math.min(min, map[i + 1][y1]);
        }

        for (int i = y1; i < y2; i++) {
            map[x2][i] = map[x2][i + 1];
            min = Math.min(min, map[x2][i + 1]);
        }

        for (int i = x2; i > x1; i--) {
            map[i][y2] = map[i - 1][y2];
            min = Math.min(map[i - 1][y2], min);
        }

        for (int i = y2; i > y1; i--) {
            map[x1][i] = map[x1][i - 1];
            min = Math.min(map[x1][i - 1], min);
        }

        map[x1][y1 + 1] = stock;
        min = Math.min(map[x1][y1 + 1], min);

        return min;
    }
}

/**
 * 행렬 테두리 회전하기
 * 시계 방향으로 회전하기 때문에 dx, dy 를 반시계로 회전하게끔 셋팅하고 회전시킨다.
 */