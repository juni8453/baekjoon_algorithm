package programmers.brute_force;

public class 최소직사각형_Review {
    public static void main(String[] args) {
        int[][] sizes1 = {
            {60, 50},
            {30, 70},
            {60, 30},
            {80, 40}
        };

        int[][] sizes2 = {
            {10, 7},
            {12, 3},
            {8, 15},
            {14, 7},
            {5, 15}
        };

        int[][] sizes3 = {
            {14, 4},
            {19, 6},
            {6, 16},
            {18, 7},
            {7, 11}
        };

        System.out.println(new Solution1().solution(sizes1));
        System.out.println(new Solution1().solution(sizes2));
        System.out.println(new Solution1().solution(sizes3));
    }
}

class Solution1 {
    public int solution(int[][] sizes) {
        // 명함은 회전이 가능하기 떄문에 가로, 세로 구분이 없다.
        // 2차원 배열 내 1차원 배열의 각 인덱스를 비교해 기준을 맞춰 정렬한다.
        for (int[] card : sizes) {
            if (card[0] < card[1]) {
                int tmp = card[0];
                card[0] = card[1];
                card[1] = tmp;
            }
        }

        // 각 card 인덱스 중 두 개의 큰 값을 찾아 곱하고 리턴하면 끝.
        int maxX = 0;
        int maxY = 0;
        for (int[] card : sizes) {
            maxX = Math.max(maxX, card[0]);
            maxY = Math.max(maxY, card[1]);
        }

        return maxX * maxY;
    }
}
