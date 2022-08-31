package baekjoonbronze.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj1292 {
    public static void main(String[] args) throws IOException {
        List<Integer> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int sum = 0;

        for (int i = 0; i < 1001; i++) { // 0, 1
            for (int j = 0; j <= i; j++) { // 0 <= 0, 0 <= 1, 0 <= 2 ...
                list.add(i + 1);
            }
        }

        for (int i = start; i <= end; i++) {
            sum += list.get(i - 1);
        }

        System.out.println(sum);
    }
}

// 3 ~ 7 -> end - (start-1)  2 + 3 + 3 + 3 + 4 = 15

