package study.section10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Section1003_Review {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(new Solution3_1().solution(n));
    }
}

class Solution3_1 {
    public int solution(int n) throws IOException {
        int answer = 0;
        int[] arr = new int[n];
        int[] dy = new int[n];
        dy[0] = 1; // 다이나믹 배열[0] 초기화

        BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br2.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < arr.length; i++) {
            int max = 0;

            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i] && dy[j] > max) {
                    max = dy[j];
                }
            }
            dy[i] = max + 1;
            answer = Math.max(answer, dy[i]);
        }

        return answer;
    }
}

// 8
// 5 3 7 8 6 2 9 4