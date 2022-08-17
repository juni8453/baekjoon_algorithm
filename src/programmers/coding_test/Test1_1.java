package programmers.coding_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Test1_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String x = br.readLine();
        String y = br.readLine();

        String answer = solution(x, y);
        System.out.println(answer);
    }

    private static String solution(String x, String y) {
        StringBuffer answer = new StringBuffer();
        Map<Character, Integer> xMap = new HashMap<>();
        Map<Character, Integer> yMap = new HashMap<>();
        List<Character> list = new ArrayList<>();

        for (int i = 0; i < x.length(); i++) {
            Character ch = x.charAt(i);
            xMap.put(ch, xMap.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < y.length(); i++) {
            Character ch = y.charAt(i);
            yMap.put(ch, yMap.getOrDefault(ch, 0) + 1);
        }

        for (Character key : xMap.keySet()) {
            if (yMap.containsKey(key)) {
                // 키는 같지만 value 가 다르다면,
                if (!xMap.get(key).equals(yMap.get(key))) {
                    if (xMap.get(key) > yMap.get(key)) {
                        for (int i = 0; i < yMap.get(key); i++) {
                            list.add(key);
                        }
                    } else {
                        for (int i = 0; i < xMap.get(key); i++) {
                            list.add(key);
                        }
                    }
                // 키도 같고 value 도 같다면,
                } else {
                    if (xMap.get(key).equals(yMap.get(key))) {
                        for (int i = 0; i < xMap.get(key); i++) {
                            list.add(key);
                        }
                    }
                }
            }
        }

        Set<Character> set = new HashSet<>(list);
        if (set.size() != list.size()) {
            if (set.size() == 1 && set.contains('0')) {
                return "0";
            }
        }

        list.sort(Comparator.reverseOrder());

        // 짝꿍이 없는 경우
        if (list.isEmpty()) {
            return "-1";
        }

        for (int i = 0; i < list.size(); i++) {
            answer.append(list.get(i));
        }

        return answer.toString();
    }
}
