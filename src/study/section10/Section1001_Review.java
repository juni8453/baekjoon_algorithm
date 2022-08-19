package study.section10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Section1001_Review {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(new Solution().solution(n));
    }
}

class Solution {
    public int solution(int n) {
        int[] dy = new int[n + 1]; // 1번 인덱스부터 사용하기 위해서
        dy[1] = 1;
        dy[2] = 2;

        for (int i = 3; i < dy.length; i++) {
            dy[i] = dy[i - 1] + dy[i - 2];
        }

        return dy[n];
    }
}
