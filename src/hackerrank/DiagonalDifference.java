package hackerrank;

import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] arr = new int[n][n];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int answer = solution(arr);
        System.out.println(answer);
    }

    private static int solution(int[][] arr) {
        int answer = 0;

        // TODO 3*3 배열일 떄, 대각선이 되는 인덱스를 찾아보자.
        //  arr[0][0] = 1
        //  arr[1][1] = 5
        //  arr[2][2] = 9 <- 여기가 정 대각선
        //  arr[0][2] = 3
        //  arr[1][1] = 5
        //  arr[2][0] = 7 <- 여기가 반대 대각

        // TODO 대각선이 되는 인덱스 규칙을 찾았다.
        //  정대각선은 [i][j] 라면 i = j, i와 j가 0부터 n까지 1씩 증가
        //  반대 대각선은 [i][j] 라면 i가 0부터 n까지 1씩 증가, j가 n부터 0까지 1씩 감소

        int[] naturalArr = new int[arr.length];
        int[] reverseArr = new int[arr.length];
        int naturalArrSum = 0;
        int reverseArrSum = 0;

        for (int i = 0; i < arr.length; i++) {
            naturalArr[i] = arr[i][i];
            naturalArrSum += naturalArr[i];
        }

        int j = arr.length;

        for (int i = 0; i < arr.length; i++) {
            j--;
            reverseArr[i] = arr[i][j];
            reverseArrSum += reverseArr[i];
        }

        answer = naturalArrSum - reverseArrSum;

        // TODO
        //  음수 나왔을 때 양수로 만들어주는 작업 해줘야 함
        if (answer < 0) {
            answer *= -1;
        }

        return answer;
    }
}
