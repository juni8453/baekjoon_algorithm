package studyReview.DFS;

public class DFS0703 {
    public static void main(String[] args) {
        int number = 5;
        int answer = DFS(number);
        System.out.println(answer);
    }

    private static int DFS(int number) {
        // number == 0  기준으로 잡아버리면 곱하기기 떄문에 무조건 0이 리턴된다.
        if (number == 1) {
            return 1;

        } else {
            return number * DFS(number - 1);
        }
    }
}

// 5 * DFS(4)
// 4 * DFS(3)
// 3 * DFS(2)
// 2 * DFS(1)
// 1 * DFS(0)