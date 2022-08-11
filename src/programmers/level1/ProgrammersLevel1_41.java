package level1;

import java.util.Arrays;
import java.util.Scanner;

public class ProgrammersLevel1_41 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int column = sc.nextInt();
        int row = sc.nextInt();

        int[][] arr1 = new int[column][row];
        int[][] arr2 = new int[column][row];

        for (int i = 0; i < column; i++) {
            for (int k = 0; k < row; k++) {
                arr1[i][k] = sc.nextInt();
            }
        }

        for (int i = 0; i < column; i++) {
            for (int k = 0; k < row; k++) {
                arr2[i][k] = sc.nextInt();
            }
        }

        int[][] result = ProgrammersLevel1_41.solution(arr1, arr2);

        Arrays.stream(result).forEach(arr -> System.out.print(Arrays.toString(arr) + " "));
    }

    private static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = arr1;

        for (int i = 0; i < answer.length; i++) {
            for (int k = 0; k < answer[i].length; k++) {
                answer[i][k] = arr1[i][k] + arr2[i][k];
            }
        }

        return answer;

    }
}