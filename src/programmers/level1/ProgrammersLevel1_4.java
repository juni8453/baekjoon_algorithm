package programmers.level1;

import java.util.Scanner;

public class ProgrammersLevel1_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        double answer = solution(arr);
        System.out.println(answer);
    }

    private static double solution(int[] arr) {
        double answer = 0;
        int sum = 0;

        for(int i=0; i<arr.length; i++) {
            sum += arr[i];
        }

        answer = (double)sum / arr.length;

        return answer;
    }
}
