package backjoonsliver.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연산자_끼워넣기 {
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;
    static int[] operator = new int[4]; // 연산자 갯수
    static int[] number; // 숫자
    static int N; // 숫자 갯수

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        number = new int[N];

        // 숫자 입력
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        // 연산자 입력
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        // depth 는 0이 아니라 1부터 진행되어야 한다.
        // 왜냐하면, 0부터 진행되면 맨 처음에 자기 자신을 한번 더 더하기 때문
        DFS(number[0], 1);

        System.out.println(MAX);
        System.out.println(MIN);
    }

    public static void DFS(int num, int depth) {
        // 완전 탐색이기 때문에 if-else 구문 사용
        // if 에 탈출 부분 작성
        // 항상 노드 숫자와 깊이가 같아지면 탈출 구문을 작성해주자.
        if (N == depth) {
            MAX = Math.max(MAX, num);
            MIN = Math.min(MIN, num);
            return;

        } else {
            for (int i = 0; i < operator.length; i++) {
                // 연산자 갯수를 검증한다.
                if (operator[i] > 0) {
                    operator[i]--;

                    switch (i) {
                        case 0: DFS(num + number[depth], depth + 1); break;
                        case 1: DFS(num - number[depth], depth + 1); break;
                        case 2: DFS(num * number[depth], depth + 1); break;
                        case 3: DFS(num / number[depth], depth + 1); break;
                    }

                    operator[i]++; // 돌아오는 재귀를 수행할 수 있도록 연산자 갯수를 복구한다.
                }
            }
        }
    }
}

// 첫째 줄에 만들 수 있는 식의 최댓값, 둘째 줄에 만들 수 있는 식의 최솟값을 출력한다.
/*
* 1. 식의 계산은 연산자 우선 순위를 무시하고 앞에서부터 진행한다.
* 2. 나눗셈은 정수 나눗셈의 몫만을 취한다.
* 3. 음수를 양수로 나눌 땐 양수로 바꾼 뒤 몫을 취하고 그 몫을 음수로 바꾼다.
* 4. 3번째 입력은 +, - , *, / 의 갯수이다.
* */
