package programmers.hash;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


//[["crow_mask", "face"], ["blue_sunglasses", "face"], ["smoky_makeup", "face"]]

public class Spy {
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

        System.out.println(new Solution().solution(clothes));
        System.out.println(new Solution().solution(clothes2));
    }
}

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> map = new HashMap<>();

        for (String[] cloth : clothes) {
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
        }

        List<Integer> values = map.values().stream().map(key -> key.intValue())
            .collect(Collectors.toList());

        // 입지 않는 경우를 추가해 모든 경우의 수를 뽑아내자.
        for (int value : values) {
            answer *= value + 1;
        }

        // 모든 경우의 수에서 아무 옷도 입지 않는 경우는 없으므로 해당 경우는 제외한다.
        return answer - 1;
    }
}

// 하루에 하나의 옷은 꼭 착용한다.
// 옷이 곂치지 않는 최대의 수를 출력해라.