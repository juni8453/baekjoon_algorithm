package study.section4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Section0404 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String a = sc.next(); // S 문자열
        String t = sc.next(); // T 단어 -> T 단어는 S 문자열보다 길이가 작거나 같다.

        int solution = solution(a, t);

        System.out.println(solution);
    }

    private static int solution(String a, String t) {
        int answer = 0;
        Map<Character, Integer> aMap = new HashMap<>();
        Map<Character, Integer> bMap = new HashMap<>();

        // 윈도우 생성
        for (char x : t.toCharArray()) {
            aMap.put(x, aMap.getOrDefault(x, 0) + 1);
        }

        // 윈도우와 비교할 bMap 셋팅
        for (char x : a.toCharArray()) {
            bMap.put(x, bMap.getOrDefault(x, 0) + 1);
        }

        if (aMap.equals(bMap)) {
            answer ++;
        }

        return answer;
    }
}


/* T 단어에 S 문자열과 아나그램이 되는 부분 문자열의 개수는 ?
* 아나그램 판별 시 대 소문자가 구분됩니다.
* S (bacAacba) / T (abc)
* {b a c} {a c b} {c b a}
* output = 3
* */

// for (char c : aChars) {
// aMap.put(c, aMap.getOrDefault(c, 0) + 1);
// }