package backjoonsliver.strings;

import java.io.*;
import java.util.*;

public class 영단어_암기는_괴로워 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // Map<단어, 등장 횟수>
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            if (word.length() < m) {
                continue;
            }

            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // 각 value 를 확인해서 value 기준 내림차순으로 해당하는 key 값을 정렬한다.
        List<String> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> {
            // 등장 횟수가 같다면 긴 단어 먼저, 그 다음에 사전 순으로 정렬
            if (map.get(o1).equals(map.get(o2))) {
                if (o1.length() == o2.length()) { // 단어 길이가 같다면 사전순
                    return o1.compareTo(o2);
                }

                return o2.length() - o1.length(); // 단어 길이가 다르면 긴 단어 먼저
            }

            return map.get(o2).compareTo(map.get(o1)); // 자주 나오는 단어일수록 앞에
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < keySet.size(); i++) {
            sb.append(keySet.get(i)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}

// 1. 자주 나오는 단어일 수록 앞에 배치
// 2. 길 수록 앞에 배치
// 3. 알파벳 사전 순으로 앞에 배치
// m 이상인 단어들만 외우려고 한다.

/*
    ant (x)
    append (1)
    apple (2)
    apple
    sand (3)
    sand
    sand
* */