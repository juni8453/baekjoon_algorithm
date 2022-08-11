//package programmers.level2;
//
//public class Level2_1Review {
//
//    public static void main(String[] args) {
//        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
//        int n = 3;
//        System.out.println(new Solution().solution(n, computers));
//    }
//
//    public static class Solution {
//        public int solution(int n, int[][] computers) {
//            int answer = 0;
//            boolean[] visited = new boolean[n + 1];
//
//            dfs(1);
//
//            return answer;
//        }
//
//        public void dfs(int startNode) {
//            if () {
//
//            } else {
//                // 1번 노드를 기준으로 수도 코드 작성
//                // 1번 노드는 2번 노드와 연결되어있다.
//                // 연결된 노드로 넘어가면서 visited 에 해당 노드 인덱스 값을 true 로 변경, 방문한다.
//                // 2번 노드를 방문했고 1,2 번 노드는 방문 체크가 되어있으므로 3번 노드를 확인할 것이다.
//                // 3번 노드는 연결된 노드가 없기 떄문에 (탈출 구문) answer 를 1 증가시킨다.
//            }
//        }
//    }
//}
//
///*
//
//[1]
// |
//[2]  [3] -> 연결된 네트워크 2개
//
//1 1 0
//1 1 0
//0 0 1
//
//-> Output = 2
//
//* */
