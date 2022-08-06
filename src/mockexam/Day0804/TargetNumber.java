//package mockexam.Day0804;
//
//import java.util.Scanner;
//
//public class TargetNumber {
//    // DFS 문제에선 항상 정답을 static 으로 놓는 경우가 있는 듯..
//    static int answer;
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int numbers = sc.nextInt();
//        int targetNumber = sc.nextInt();
//
//        int[] numberArr = new int[numbers];
//
//        int answer = solution(numberArr, targetNumber);
//        System.out.println(answer);
//    }
//
//    private static int solution(int[] numberArr, int targetNumber) {
//        // 완전탐색으로 모든 경우의 수를 고려 (브루트포스로 풀면 효율성에서 커트 당할듯한 문제 ?)
//        // DFS, 노드를 탐색하면서 타겟 넘버와 값이 같다면 경우의 수 1씩 증가
//        // 깊이나 합을 설정하지 않는 경우가 많으므로 일단 빼고 ..
////        int depth = 0;
////        int sum = 0;
//
//        // 숫자 배열, 뎁스, 타겟넘버, 경우의 수
//        dfs(numberArr, targetNumber, 0, 0);
//
//        return answer;
//    }
//
//    private static void dfs(int[] numberArr, int targetNumber, int depth, int sum) {
//        // 마지막 노드까지 탐색했다면 ?
//        if (depth == numberArr.length) {
//            if (sum == targetNumber) {
//                answer ++;
//            } else {
//                dfs();
//                dfs();
//            }
//        }
//    }
//}
//
///*
//* [1,1,1,1,1] 의 다섯 숫자로 targetNumber 3 을 만들기 위해선 5가지 방법이 필요
//* 따라서 answer = 5
//*
//* 만약 [1,1,1] 에 target 이 1이라면 ?
//* 첫 번째 수에서 더하거나 빼거나 (2가지의 경우의 수)
//* 두 번째 수에서 더하거나 뺴거나 (2가지의 경우의 수)
//* 세 번째 수에서 더하거나 빼거나 (2가지의 경우의 수)
//* 즉 8가지 경우의 수가 존재.
//*
//* DFS 에서 두 가지만..
//* 1. 한 턴에 DFS 함수를 계속해서 콜하면서 어떤 동작을 수행하는가 ?
//* 2. 탈출 조건은 깊이가 배열과 같아질 때로 설정한다.
//* */
