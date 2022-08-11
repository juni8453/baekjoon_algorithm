package study.section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Section0805 {
    static int answerCount = Integer.MAX_VALUE;
    static int changeMoney = 0;
    static Integer[] categories;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        categories = new Integer[n];

        for (int i = 0; i < categories.length; i++) {
            categories[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(categories, Collections.reverseOrder());

        changeMoney = Integer.parseInt(br.readLine());

        DFS(0, 0);
        System.out.println(answerCount);
    }

    private static void DFS(int depth, int sum) {

        // 계산할 필요가 없는 부분 체크 후 바로 탈출하도록 설정
        if (sum > changeMoney) return;
        if (depth > answerCount) return;

        // 탈출 구간 및 판단 구간 설정
        // 노드를 거치면서 생기는 합이 거슬러줘야 하는 값과 같다면 판단
        // depth 자체가 이전 노드의 거슬러줄 떄 필요한 동전 갯수
        if (sum == changeMoney) {
            answerCount = Math.min(answerCount, depth);
        // 재귀 함수 동작 구간 설정
        } else {
            for (int i=0; i< categories.length; i++) {
                // 각 원소를 더하는 경우의 수 밖에 없으므로 재귀 호출 부분은 하나
                // 대신 배열을 돌면서 하나 씩 더해야 하기 때문에 for 문 사용
                DFS(depth + 1, sum + categories[i]);
            }
        }
    }
}
