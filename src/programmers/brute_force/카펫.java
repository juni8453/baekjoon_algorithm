package programmers.brute_force;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 카펫 {
    public static void main(String[] args) {
        int brown = 8;
        int yellow = 1;

        System.out.println(Arrays.toString(new Solution3().solution(brown, yellow)));
    }
}

class 약수 {
    int a;
    int b;

    public 약수(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

class Solution3 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        List<약수> list = new ArrayList<>();
        int sum = brown + yellow;

        // sum 의 약수를 모두 구한다.
        // 약수 객체 생성은 나누는 값 (가로) 가 몫 (세로) 보다 클 떄만 생성하도록 한다.
        // 가로와 세로 길이는 최소 3 이상일 떄만 약수 객체를 생성하도록 한다.
        for (int i = 1; i < sum; i++) {
            if (sum % i == 0 && i >= (sum / i) && i >= 3 && (sum / i) >= 3) {
                list.add(new 약수(i, sum / i));
            }
        }

        // 약수 객체가 하나만 생성되었다면 바로 정답처리
        if (list.size() == 1) {
            answer[0] = list.get(0).a;
            answer[1] = list.get(0).b;

        // 두 개 이상으로 나왔다면 약수만큼의 가로 세로 길이를 통해 맵을 만든다.
        } else {
            for (int i = 0; i < list.size(); i++) {
                // 내부 타일 갯수 = (약수 가로길이 - 2) * (약수 세로길이 - 2)
                // 외부 타일 갯수 = sum - 내부 타일 갯수
                // brown = 외부 타일 갯수, yellow = 내부 타일 갯수 라면 정답
                int insideCount = (list.get(i).a - 2) * (list.get(i).b - 2);
                int outsideCount = sum - insideCount;

                if (insideCount == yellow && outsideCount == brown) {
                    answer[0] = list.get(i).a;
                    answer[1] = list.get(i).b;
                    return answer;
                }
            }
        }

        return answer;
    }
}

/* 카펫 크기 구하기
* 1. 가로는 세로보다 길다.
* 2. 가로, 세로는 최소 3 이상이다.
* 3. 위 조건 두 개를 가지고 약수를 걸러준다.
* */
