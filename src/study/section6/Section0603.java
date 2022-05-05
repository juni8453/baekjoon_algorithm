package study.section6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Section0603 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = solution(arr);
        Arrays.stream(answer).forEach(s -> System.out.print(s + " "));
    }

    private static int[] solution(int[] arr) {
        // 삽입 정렬을 활용해 arr 배열을 오름차순으로 정렬한다.
        // arr[1] 인덱스 값을 최초 KEY 로 설정해서 앞 인덱스 값과 비교한다.
        // 만약 Key 인덱스 값보다 앞 인덱스 값이 크다면 서로 자리를 바꾼다.
        // 비교할 앞의 인덱스가 남았다면 계속해서 비교하며 자리를 옮긴다.

        // key = 1 이면 비교할 인덱스 1개
        // key = 2 이면 비교할 인덱스 2개

        // [1] > [0] 비교 true -> 교체
        // [2] > [1] 비교 true -> 교체 [1] > [0] -> true -> 교체 .. 반복

        for (int i = 1; i < arr.length; i++) {

            // 앞 인덱스를 계속해서 탐색해줘야하기 때문에 for 문이 하나 더 필요하다.
            for (int j = i; j > 0; j--) {

                if (arr[j - 1] > arr[j]) { // [0] > [1] true -> 자리 교체
                    int tmp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }

        return arr;
    }
}
