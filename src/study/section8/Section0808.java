//package study.section8;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
//public class Section0808 {
//    static int n = 0;
//    static int sum = 0;
//    static int[] firstArr = new int[n];
//    static int[] answerArr = new int[n];
//
//    public static void main(String[] args) {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int f = 0;
//
//        try {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            n = Integer.parseInt(st.nextToken());
//            f = Integer.parseInt(st.nextToken()); // 가장 아래의 숫자
//        } catch (IOException ioException) {
//            ioException.printStackTrace();
//        }
//
//        for (int i = 0; i < n; i++) {
//            firstArr[i] = i;
//        }
//
//        DFS(0, 0);
//        Arrays.stream(answerArr).forEach(answer -> System.out.print(answer + " "));
//    }
//
//    private static void DFS(int depth, int indexValue) {
//        // 탈출 및 확인 부분 작성
//        // 맨 위의 줄이 만들어졌다면 계산하면서 k 과 최종 sum 값을 확인
//        // 파스칼 삼각형 공식 사용 <n-1>C<r-1> + <n-1>C<r>
//        if (depth == n) {
//            // 파스칼 삼각형을 구할 수 있는 메서드 호출
//            isAnswer();
//
//        // DFS 실행 부분 작성
//        } else {
//            for (int i = 0; i < n; i++) {
//                DFS(depth + 1, firstArr[i]);
//            }
//        }
//    }
//
//    private boolean isAnswer() {
//        if () {
//
//        } else {
//
//        }
//    }
//}
//
//// n, f(가장 아래의 수) 가 주어졌을 때, 가장 위의 수 배열을 출력하는 프로그램을 작성하시오.
