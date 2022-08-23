package programmers.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Spy_Review {
    public static void main(String[] args) {
        String[][] clothes = {
            {"yellow_hat", "headgear"},
            {"blue_sunglasses", "eyewear"},
            {"green_turban", "headgear"}
        };

        String[][] clothes2 = {
            {"crow_mask", "face"},
            {"blue_sunglasses", "face"},
            {"smoky_makeup", "face"}
        };

        System.out.println(new Solution3_1().solution(clothes));
        System.out.println(new Solution3_1().solution(clothes2));
    }
}

class Solution3_1 {
    public int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> map = new HashMap<>();
        for (String[] cloth : clothes) {
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1); // headgear - 2, eye - 1
        }

        // 모든 경우의 수 구하기
        List<Integer> mapValues = new ArrayList<>(map.values());
        for (int value : mapValues) {
            answer *= value + 1;
        }

        // 아무 것도 안입을 수는 없으므로 경우의 수 하나 빼주기
        answer -= 1;

        return answer;
    }
}
