package programmers.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 귤_고르기 {
    public static void main(String[] args) {
        int k = 6;
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};

        int k2 = 4;
        int[] tangerine2 = {1, 3, 2, 5, 4, 5, 2, 3};

        int k3 = 2;
        int[] tangerine3 = {1, 1, 1, 1, 2, 2, 2, 3};

        System.out.println(new Solution1().solution(k, tangerine));
        System.out.println(new Solution1().solution(k2, tangerine2));
        System.out.println(new Solution1().solution(k3, tangerine3));
    }
}

class Solution1 {
    public int solution(int k, int[] tangerine) {
        // Map<귤 사이즈, 사이즈에 따른 귤 갯수>
        Map<Integer, Integer> sizeMap = new HashMap<>();
        int answer = 0;

        for (int size : tangerine) {
            sizeMap.put(size, sizeMap.getOrDefault(size, 0) + 1);
        }

        // 맵에서 키만 빼내 리스트 생성
        List<Integer> keyList = new ArrayList<>(sizeMap.keySet());

        // 사이즈에 따른 귤 갯수 기준 내림차순 정렬
        // 귤 사이즈 2,3,5,1,4 순서로 귤 갯수가 많다.
        keyList.sort((o1, o2) -> sizeMap.get(o2) - sizeMap.get(o1));

        int i = 0;
        while (k > 0) {
            k -= sizeMap.get(keyList.get(i));
            answer++;
            i++;
        }

        return answer;
    }
}

// Greedy 유형
// 귤의 종류를 최소한으로 하기 위해선 귤의 개수가 많은 귤을 차례로 선택하면 된다.
// 귤의 개수가 많은 귤을 차례로 선택했을 때, 항상 최적의 해를 보장받기 때문에 Greedy 유형으로 풀이하는 것.