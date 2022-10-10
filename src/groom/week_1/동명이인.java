package groom.week_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동명이인 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String str = st.nextToken();

        String[] names = new String[n];
        for (int i = 0; i < n; i++) {
            names[i] = br.readLine();
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (checkName(str, names, i)) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static boolean checkName(String str, String[] names, int index) {
        if (names[index].contains(str)) {
            return true;
        }


        return false;
    }
}

// n 명의 학생들이 있고 어떤 사람의 이름인 str 이 주어졌을 때, str 을 포함한 다른 학생들의 명수를 구해라.
// 단, 같은 이름을 가진 사람이 여러 명일 수 있다.
