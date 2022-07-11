package study.section4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Section0404 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String t = br.readLine();

        int answer = solution(s, t);

        System.out.println(answer);
    }

    private static int solution(String s, String t) {
        int count = 0;
        int lt = 0;
        int rt = t.length() - 1;

        Map<Character, Integer> aMap = new HashMap<>();
        Map<Character, Integer> bMap = new HashMap<>();

        for (char x : t.toCharArray()) {
            bMap.put(x, bMap.getOrDefault(x, 0) + 1);
        }

        for (int i = 0; i < rt; i++) {
            aMap.put(s.charAt(i), aMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = rt; i < s.length(); i++) {
            aMap.put(s.charAt(i), aMap.getOrDefault(s.charAt(i), 0) + 1);

            if (aMap.equals(bMap)) {
                count ++;
            }

            aMap.put(s.charAt(lt), aMap.get(s.charAt(lt)) - 1);

            if (aMap.get(s.charAt(lt)) == 0) {
                aMap.remove(s.charAt(lt));
            }

            lt ++;
        }

        return count;
    }
}


/* T 단어에 S 문자열과 아나그램이 되는 부분 문자열의 개수는 ?
* 아나그램 판별 시 대 소문자가 구분됩니다.
* S (bacAacba) / T (abc)
* {b a c} {a c b} {c b a}
* output = 3
* */