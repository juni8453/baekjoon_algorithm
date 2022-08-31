package baekjoonbronze.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Boj2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> allList = new ArrayList<>();
        int sum = 0;
        int fakeA = 0;
        int fakeB = 0;

        for (int i = 0; i < 9; i++) {
            allList.add(Integer.parseInt(br.readLine()));
            sum += allList.get(i);
        }

        Collections.sort(allList);

        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - allList.get(i) - allList.get(j) == 100) {
                    fakeA = allList.get(i);
                    fakeB = allList.get(j);
                }
            }
        }

        // 진짜 난쟁이 출력
        for (int i = 0; i < 9; i++) {
            if (allList.get(i) == fakeA || allList.get(i) == fakeB) {
                continue;
            } else {
                System.out.println(allList.get(i));
            }
        }
    }
}
