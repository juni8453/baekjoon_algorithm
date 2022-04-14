package study.section3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Section0302 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arrA = new int[n];
        for (int i = 0; i < arrA.length; i++) {
            arrA[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] arrB = new int[m];
        for (int i = 0; i < arrB.length; i++) {
            arrB[i] = sc.nextInt();
        }

        List<Integer> result = solution(n, m, arrA, arrB);
        result.stream().forEach(s -> System.out.print(s + " "));
    }

    private static List<Integer> solution(int n, int m, int[] arrA, int[] arrB) {
        List<Integer> answer = new ArrayList<>();

        // Section3-1 에서 배운 Two Pointer 를 응용해서 풀면 ?
        int pointerA = 0, pointerB = 0;

        Arrays.sort(arrA);
        Arrays.sort(arrB);

        while (pointerA < n && pointerB < m) {

            // arrA = 4,5,6,7,8
            // arrB = 1,5,7,9

            if (arrA[pointerA] > arrB[pointerB]) {
                pointerB++;

            } else if (arrA[pointerA] < arrB[pointerB]) {
                pointerA++;

            } else if (arrA[pointerA] == arrB[pointerB]) {
                answer.add(arrA[pointerA]);
                pointerA++;
                pointerB++;
            }
        }

        return answer;
    }
}

// A, B 두 개의 배열이 주어지면, 두 배열의 공통 원소를 추출하여 오름차순으로 출력해라.
// 미리 두 개의 배열을 오름차순 정렬한다.
// 각 배열의 내부원소는 중복되지 않는다.
/*
* n = 5
* arrA = 1 3 9 5 2
* m = 5
* arrB = 3 2 5 7 8
* */