package studyReview.DFS;

import java.io.IOException;
import java.util.Scanner;

public class DFS0701 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        DFS(number);
    }

    private static void DFS(int number) {
        if (number == 0) {
            return;
        }

        DFS(number - 1);
        System.out.print(number + " ");

    }
}