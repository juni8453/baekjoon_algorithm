package study.section4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Section0401 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int studentCount = Integer.parseInt(br.readLine());
        String line = br.readLine();
        String[] votes = line.split("");

        String answer = solution(studentCount, votes);
        System.out.println(answer);
    }

    private static String solution(int studentCount, String[] votes) {
        String answer = "";

        // TODO <후보 key, 몇 명이 뽑았는지 value>
        Map<String, Integer> resultMap = new HashMap<>();
        resultMap.put("A", 0);
        resultMap.put("B", 0);
        resultMap.put("C", 0);
        resultMap.put("D", 0);
        resultMap.put("E", 0);

        for (String key : resultMap.keySet()) {
            for (int i = 0; i < studentCount; i++) {
                // TODO key 와 vote[i] 가 일치하면 해당 알파벳에 카운트를 +1 시킨다.
                if (key.equals(votes[i])) {
                    resultMap.put(key, resultMap.get(key) + 1);
                }
            }
        }

        // TODO 반복문이 끝나면 resultMap 에 데이터가 담긴다.
        //  담긴 데이터를 가지고 최대 값 알고리즘 적용
        int max = 0; // resultMap 의 value

        for (int i = 0; i < resultMap.size(); i++) {
            for (String key : resultMap.keySet()) {
                Integer integer = resultMap.get(key);

                if (integer > max) {
                    max = integer;
                    answer = key;
                }
            }
        }

        return answer;
    }
}

// 15
// B A C B A C C A C C A C C B D E D E
// C 당선