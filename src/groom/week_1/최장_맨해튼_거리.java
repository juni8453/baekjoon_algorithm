package groom.week_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 최장_맨해튼_거리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        int firstMax = Integer.MIN_VALUE;
        int firstMin = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            if (list.get(i) > firstMax) {
                firstMax = list.get(i);
            }

            if (list.get(i) < firstMin) {
                firstMin = list.get(i);
            }
        }

        int firstSum = firstMax - firstMin;
        list.remove(list.indexOf(firstMax));
        list.remove(list.indexOf(firstMin));

        int secondMax = Integer.MIN_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for (int i = 0; i < 2; i++) {
            if (list.get(i) > secondMax) {
                secondMax = list.get(i);
            }

            if (list.get(i) < secondMin) {
                secondMin = list.get(i);
            }
        }

        int secondSum = secondMax - secondMin;

        System.out.println(firstSum + secondSum);

    }
}

// 4개의 정수로 찾을 수 있는 최장 맨해튼 거리를 찾고 반환하시오.
// 4개의 정수 중 각 2개를 짝짓고 x1, x2, y1, y2 라고 가정한 뒤 (x1 - x2) + (y1 - y2)
// [1, 3, 5, 10] -> return 11
// 가장 큰 값 - 가장 작은 값 후 나머지 두 값을 양수가 되도록 빼주면 끝.
