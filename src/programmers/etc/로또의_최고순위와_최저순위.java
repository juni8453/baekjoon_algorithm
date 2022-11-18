package programmers.etc;

import java.util.Arrays;

public class 로또의_최고순위와_최저순위 {
    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};

        int[] lottos2 = {45, 4, 35, 20, 3, 9};
        int[] win_nums2 = {20, 9, 3, 45, 4, 35};

        int[] lottos3 = {0, 0, 0, 0, 0, 0};
        int[] win_nums3 = {38, 19, 20, 40, 15, 25};

        System.out.println(Arrays.toString(new Solution1().solution(lottos, win_nums)));
        System.out.println(Arrays.toString(new Solution1().solution(lottos2, win_nums2)));
        System.out.println(Arrays.toString(new Solution1().solution(lottos3, win_nums3)));
    }
}

class Solution1 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int count = 0;
        int zeroCount = 0;
        int[] result = new int[2];

        // 오름차순 정렬
        Arrays.sort(lottos);
        Arrays.sort(win_nums);

        // 최초 상태에서 서로 몇 개의 수가 곂치는지 찾는다.
        for (int i = 0; i < 6; i++) {
            int stand = lottos[i];

            if (stand == 0) {
                zeroCount++;
            }

            for (int j = 0; j < 6; j++) {
                int compare = win_nums[j];

                if (stand == compare) {
                    count++;
                }
            }
        }

        int maxRate = zeroCount + count;
        int minRate = count;

        result[0] = getGrade(maxRate);
        result[1] = getGrade(minRate);

        return result;
    }

    public int getGrade(int n) {
        switch(n) {
            case 6 :
                return 1;
            case 5 :
                return 2;
            case 4 :
                return 3;
            case 3 :
                return 4;
            case 2 :
                return 5;
            default :
                return 6;
        }
    }
}

// 구매했던 로또로 당첨이 가능했던 최고 순위와 최저 순위를 알아보자.
// 알아볼 수 없어진 번호는 0으로 표기한다.

/**
 * 구매 번호 - 0, 0, 1, 25, 31, 44
 * 당첨 번호 - 1, 6, 10, 19, 31, 45
 * <p>
 * 최초 상태에서 몇 개의 번호가 곂치는지 찾는다. 위 예시에서는 2개 곂침 -> 최소 5등
 * 하나도 곂치는게 없다면 그저 낙차로 생각 (전부 안 곂치도록 숫자를 셋팅하면 되니까)
 * 최대 등수는 0 갯수 + 곂친 숫자 갯수
 * <p>
 * 0, 0, 0, 0, 0, 0
 * <p>
 * 15, 19, 20, 25, 38, 40
 */