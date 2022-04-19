package study.section4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Section0402 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String first = br.readLine();
        String second = br.readLine();

        String answer = solution(first, second);
        System.out.println(answer);
    }

    private static String solution(String first, String second) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        char[] arr1 = first.toCharArray();
        char[] arr2 = second.toCharArray();

        if (arr1.length != arr2.length) {
            return "NO";
        }

        for (char x : arr1) {
            map1.put(x, map1.getOrDefault(x, 0) + 1);
        }

        for (char x : arr2) {
            map2.put(x, map2.getOrDefault(x, 0) + 1);
        }

        // TODO
        //  A(2) a(1) b(1) C(1) e(2)
        //  a(1) A(2) b(1) C(1) e(2)
        //  첫 번째 검증 -> 길이가 같은가 ? 배열 만들 때 이미 검증 완료
        //  두 번째 검증 -> Key 와 Value 모두 같은가 ?

        String answer = " ";
        boolean check = false;

        for (char key : map1.keySet()) {
            Integer a = map1.get(key);
            Integer b = map2.get(key);

            if (a.equals(b)) {
                check = true;
            } else {
                check = false;
                break;
            }
        }

        if (check) {
            answer = "YES";
        } else {
            answer = "NO";
        }

        return answer;
    }
}

// 첫 줄에 첫 번째 단어 입력
// 두 번째 줄에 두 번째 단어 입력
// 두 단어가 아나그램인지 판별하는 프로그램을 작성해라.
