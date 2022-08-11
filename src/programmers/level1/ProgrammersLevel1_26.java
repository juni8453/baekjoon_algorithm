package programmers.level1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProgrammersLevel1_26 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] answers = new int[n];

        for (int i = 0; i < answers.length; i++) {
            answers[i] = sc.nextInt();
        }

        int[] result = solution(answers);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    private static int[] solution(int[] answers) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] personCount = new int[3];

        for (int i = 0; i < answers.length; i++) {
            if (a[i % 5] == answers[i]) {
                personCount[0]++;
            }

            if (b[i % 8] == answers[i]) {
                personCount[1]++;
            }

            if (c[i%10] == answers[i]) {
                personCount[2]++;
            }
        }

        List<Integer> list = new ArrayList<>();
        int max = Math.max(Math.max(personCount[0], personCount[1]), personCount[2]);

        if (max == personCount[0]) {
            list.add(1);
        }

        if (max == personCount[1]) {
            list.add(2);
        }

        if (max == personCount[2]) {
            list.add(3);
        }

        int[] answer = new int[list.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
