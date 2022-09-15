package mockexam.Day0915;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장긴증가하는부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        int answer = 0;
        int[] arr = new int[length];
        int[] dy = new int[arr.length];
        dy[0] = 1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < arr.length; i++) {
            int max = 0;

            for (int j = i - 1; j >= 0; j--) { // i 인덱스 기준 앞으로 비교해야 하기 때문에.
                if (arr[i] > arr[j]) {
                    max = Math.max(max, dy[j]);
                }
            }

            dy[i] = max + 1; // dy 배열 중 가장 큰 값에 + 1 한 값을 dy[i] 에 갱신
            answer = Math.max(answer, dy[i]);
        }

        if (arr.length == 1) {
            answer = 1;
        }

        System.out.println(answer);
    }
}
