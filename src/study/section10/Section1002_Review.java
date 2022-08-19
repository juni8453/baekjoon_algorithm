package study.section10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Section1002_Review {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(new Solution2().solution(n));
    }
}

class Solution2 {
    public int solution(int n) {
        int[] dy = new int[n + 2];
        dy[1] = 1;
        dy[2] = 2;

        for (int i = 3; i < dy.length; i++) {
            dy[i] = dy[i - 1] + dy[i - 2];
        }

        return dy[n + 1];
    }
}
