package study.section4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Section0402Answer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();

        String answer = solution(a, b);
        System.out.println(answer);
    }

    private static String solution(String a, String b) {
        String answer = "YES";

        Map<Character, Integer> map1 = new HashMap<>();
        for (char x : a.toCharArray()) {
            map1.put(x, map1.getOrDefault(x, 0) + 1);
        }

        for (char x : b.toCharArray()) {
            // 다른 키가 있거나 이미 Value 값이 모두 빠져서 0인 경우 바로 "NO" 리턴
            if (!map1.containsKey(x) || map1.get(x) == 0) {
                return "NO";
            } else {
                map1.put(x, map1.get(x) - 1);
            }
        }

        return answer;
    }
}
