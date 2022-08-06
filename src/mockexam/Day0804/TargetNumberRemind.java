package mockexam.Day0804;

public class TargetNumberRemind {

    static int count = 0;
    static int targetNumber = 4;
    static int[] numbers = {4, 1, 2, 1};

    public static void main(String[] args) {

        // 깊이 0, 결과 값 0 으로 깊이 우선 탐색 시작
        DFS(0, 0);
        System.out.println(count);
    }

    private static void DFS(int depth, int sum) {
        // DFS 탈출 부분 작성
        // 끝까지 탐색했다면 판단해줘야 한다.
        if (depth == numbers.length) {
            if (sum == targetNumber) {
                count ++;
            }
        // 재귀 구문 작성
        // 더하거나 뺴는 두 가지 경우의 수가 존재하므로 DFS 두 번 작성
        } else {
            DFS(depth + 1, sum + numbers[depth]);
            DFS(depth + 1, sum - numbers[depth]);
        }
    }
}
