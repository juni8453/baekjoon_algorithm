package programmers.brute_force;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 최소직사각형 {
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

        System.out.println(new Solution().solution(sizes1));
        System.out.println(new Solution().solution(sizes2));
        System.out.println(new Solution().solution(sizes3));
    }
}

class Solution {
    public int solution(int[][] sizes) {
        int maxWidth = 0;
        int maxHeight = 0;

        for (int[] card : sizes) {
            int max = Math.max(card[0], card[1]);
            int min = Math.min(card[0], card[1]);

            if (max > maxWidth) {
                maxWidth = max;
            }

            if (min > maxHeight) {
                maxHeight = min;
            }
        }

        return maxWidth * maxHeight;
    }
}

// 지갑은 다양한 명함들을 수갑할 수 있고 최대한 작아야한다.

/* 가로 세로
*  60  50
*  30  70
*  60  30
*  80  40
* */

// 가장 긴 가로길이 80, 가장 긴 세로길이 70
// 하지만 2번 명함을 가로로 눕히면 가로 80, 세로 50 크기의 지갑으로도 수납가능
