package groom.week_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 합격자_찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(br.readLine()); // 시험의 개수

        for (int i = 0; i < testCount; i++) {
            int sum = 0;
            float ave;
            int successfulCount = 0;
            int peopleCount = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] peopleGrade = new int[peopleCount]; // [1, 3, 7]

            for (int j = 0; j < peopleCount; j++) {
                peopleGrade[j] = Integer.parseInt(st.nextToken());
                sum += peopleGrade[j];
            }

            ave = (float) sum / peopleCount;
            for (int k = 0; k < peopleCount; k++) {
                if (peopleGrade[k] >= ave) {
                    successfulCount++;
                }
            }

            System.out.println(successfulCount + "/" + peopleCount);
        }
    }
}

// 매 시험 성적의 평균보다 이상인 사람을 합격자로 관리
// 시험마다 합격자 수를 a, 응시자의 수를 b 라고 한다면 a/b 형태로 표기해 기록한다.
// 매 줄에 시험 결과를 조건에 따라 시험 정보가 주어지는 순서대로 출력해라.