package study.section6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Section0602 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = solution(N, arr);

        Arrays.stream(answer).forEach(s -> System.out.print(s + " "));
    }

    private static int[] solution(int n, int[] arr) {
        // 오름차순으로 정렬된 수열 출력 (버블 정렬 사용)ㅌ
        // 인접한 2개의 레코드를 비교하여 정렬되어 있지 않다면 서로 교환한다.

        for (int i = 0; i < arr.length - 1; i++) {

            for (int k = 0; k < arr.length - 1; k++) {
                if (arr[k] > arr[k + 1]) {
                    int tmp = arr[k];
                    arr[k] = arr[k + 1];
                    arr[k + 1] = tmp;
                }
            }

        }

        return arr;
    }
}

// 7, 4, 5, 1, 3
// Index [0](7), Index [1](4) 비교 -> 뒷 인덱스 값이 더 작으니까 자리 교환 -> 4, 7, 5, 1, 3
// Index [1](7), Index [2](5) 비교 -> 뒷 인덱스 값이 더 작으니까 자리 교환 -> 4, 5, 7, 1, 3
// Index [2](7), Index [3](1) 비교 -> 뒷 인덱스 값이 더 작으니까 자리 교환 -> 4, 5, 1, 7, 3
// Index [3](7), Index [4](3) 비교 -> 뒷 인덱스 값이 더 작으니까 자리 교환 -> 4, 5, 1, 3, 7
// 1회전 종료 (제일 큰 숫자는 맨 뒤로)