package study.section7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Section0701Answer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        DFS(number);
    }

    private static void DFS(int number) {
        if (number == 0) {
            return;
        } else {
            DFS(number - 1);
            System.out.println(number + " ");
        }
    }
}
