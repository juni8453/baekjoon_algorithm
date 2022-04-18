package study.section4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Section0401Answer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int studentCount = Integer.parseInt(br.readLine());
        String[] votes = new String[studentCount];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < votes.length; i++) {
            votes[i] = st.nextToken();
        }

        String answer = solution(studentCount, votes);
        System.out.println(answer);
    }

    private static String solution(int studentCount, String[] votes) {
        String answer = " ";

        Map<String, Integer> map = new HashMap<>();

        for (String str : votes) {
            // TODO get() 은 key 의 value 값을 가져오는데, str 라는 key 가 map 에 없을 수도 있으니까 이땐 갱신이 아닌 추가를 위해 getOrDefault() 사용
            //  key   - A, B, C, D
            //  value - 1, 3, 3, 1
            //  이때 만약 str 이 E 라면, E 는 없으니까 map 에 <E, 0+1> 추가
            //  이떄 만약 str 이 A 라면, A 는 있으니까 mpa 에 <A, 1+1> 갱신
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        int max = 0;

        for (String key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                answer = key;
            }
        }

        return answer;
    }
}
