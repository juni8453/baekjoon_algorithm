package study.section3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Section0301Answer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }

        List<Integer> result = solution(n, m, a, b);
        result.stream().forEach(s -> System.out.print(s + " "));
    }

    private static List<Integer> solution(int n, int m, int[] arrA, int[] arrB) {
        List<Integer> answer = new ArrayList<>();
        int pointerA = 0, pointerB = 0;

        // 두 배열 중 하나라도 인덱스가 끝나면 while 문 빠져나오도록 설정
        while (pointerA < n && pointerB < m) {

            // 두 배열의 인덱스 내부 값을 하나하나 비교한다.
            // 둘 중 작은 값을 answer List 에 추가한다.
            if (arrA[pointerA] < arrB[pointerB]) {
                answer.add(arrA[pointerA]);
                pointerA++;
            } else {
                answer.add(arrB[pointerB]);
                pointerB++;
            }
        }

        // 배열에 남은 인덱스 내부 값들을 answer 에 추가하기 위한 작업
        while (pointerA < n) {
            answer.add(arrA[pointerA]);
            pointerA++;
        }

        while (pointerB < m) {
            answer.add(arrB[pointerB]);
            pointerB++;
        }

        return answer;
    }
}
