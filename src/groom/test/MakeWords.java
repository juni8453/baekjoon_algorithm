package groom.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MakeWords {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<String> list = new ArrayList<>();
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            list.add(br.readLine());
        }

        // 정렬 기준
        // 1. 길이기준으로 오름차순 정렬
        list.sort(Comparator.comparingInt(String::length));

        // 2. 같은 길이는 사전순서로 정렬
        list.sort((o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }

            return 0;
        });

        System.out.println(list.get(k - 1));
    }
}

// 섞여져있는 단어를 정렬하고 K 번째에 위치한 단어를 출력하고자 한다.
// 기준 1) 단어가 짧을수록 앞에 있고 길이가 같다면, 사전 순으로 정렬한다.
// 각 단어는 영어 소문자로 주어지며 1 ~ 100 이하의 길이를 가진다.