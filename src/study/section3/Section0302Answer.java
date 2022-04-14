package study.section3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Section0302Answer {
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

        Arrays.sort(arrA);
        Arrays.sort(arrB);

        int pointerA = 0, pointerB = 0;

        while (pointerA < n && pointerB < m) {
            if (arrA[pointerA] == arrB[pointerB]) {
                answer.add(arrA[pointerA]);
                pointerA++;
                pointerB++;

            } else if (arrA[pointerA] < arrB[pointerB]) {
                pointerA++;

            } else {
                pointerB++;

            }
        }

        return answer;

    }
}
