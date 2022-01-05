package baekjoonbronze.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon2747 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arrNumbers = new int[n + 1];
        arrNumbers[0] = 0;
        arrNumbers[1] = 1;

        for (int i = 2; i < arrNumbers.length; i++) {
            arrNumbers[i] = arrNumbers[i - 1] + arrNumbers[i - 2];
        }
        System.out.println(arrNumbers[n]);
    }
}

// n = 17
// 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597
