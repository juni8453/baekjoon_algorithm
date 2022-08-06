package studyReview.DFS;

public class DFS0702 {
    public static void main(String[] args) {
        int number = 11;
        DFS(number);
    }

    private static void DFS(int number) {
        // 탈출 부분
        if (number == 0) {
            return;
        } else {
            DFS(number / 2);
            System.out.print(number % 2);
        }
    }
}
