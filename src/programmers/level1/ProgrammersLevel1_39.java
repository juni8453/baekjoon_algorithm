package programmers.level1;

import java.util.Scanner;

public class ProgrammersLevel1_39 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = new int[n];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = sc.nextInt();
        }

        int answer = ProgrammersLevel1_39.solution(numbers);
        System.out.println(answer);
    }

    // TODO 0 ~ 9까지 정수 배열에서 없는 수를 탐색해 더한 수를 return
    public static int solution(int[] numbers) {
        int answer = 45;
        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }

        return answer - sum;
    }
}
