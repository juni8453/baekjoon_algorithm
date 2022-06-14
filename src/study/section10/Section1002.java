package study.section10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Section1002 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int answer = solution(N);
        System.out.println(answer);
    }

    private static int solution(int N) {
        int[] arr = new int[N + 2];
        arr[1] = 1;
        arr[2] = 2;

        for (int i = 3; i < arr.length; i++) {
            arr[i] = arr[i - 2] + arr[i - 1];
        }

        return arr[N + 1];
    }
}
