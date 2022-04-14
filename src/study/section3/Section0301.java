package study.section3;

import java.util.Arrays;
import java.util.Scanner;

public class Section0301 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] firstArray = new int[n];
        for (int i = 0; i < n; i++) {
            firstArray[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] secondArray = new int[m];
        for (int i = 0; i < m; i++) {
            secondArray[i] = sc.nextInt();
        }


        int[] answer = solution(firstArray,secondArray);
        Arrays.stream(answer).forEach(s -> System.out.print(s + " "));
    }

    private static int[] solution(int[] fistArray, int[] secondArray) {
        int[] resultArray = new int[fistArray.length + secondArray.length];
        System.arraycopy(fistArray, 0, resultArray, 0, fistArray.length);
        System.arraycopy(secondArray, 0, resultArray, fistArray.length, secondArray.length);

        Arrays.sort(resultArray);

        return resultArray;
    }
}
