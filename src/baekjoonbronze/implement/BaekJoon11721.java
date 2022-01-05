package baekjoonbronze.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon11721 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            System.out.print(str.charAt(i));
            // 9번째 인덱스일 때 개행
            if (i % 10 == 9) {
                System.out.println();
            }
        }
    }
}
