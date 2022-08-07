package studyReview.DFS;

public class DFS0704 {

    static int length = 10;

    public static void main(String[] args) {
        for (int depth = 0; depth < length; depth++) {
            int dfs = DFS(depth);
            System.out.println(dfs + " ");
        }
    }

    private static int DFS(int depth) {
        // 맨 아래 노드 2개 1로 초기화
        // 아래 노드까지 쭉 ~ 탐색하고 초기화된 값을 바탕으로 값을 구해내기 때문에 값 초기화 필요
        // 노드 2개를 초기화해준 이유는, 피보나치 수열의 첫 번쨰 두 번째 값은 1 고정이기 때문이다.
        if (depth == 0 || depth == 1) {
            return 1;
        } else {
            return DFS(depth - 1) + DFS(depth - 2);
        }
    }
}

// 1, 1, 2, 3, 5 ~
// 피보나치 수열 공식 (n-1) + (n-2)