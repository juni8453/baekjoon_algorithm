package baekjoongold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 선수과목 {

    static int[] result;
    static int[] indegree;
    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 과목의 수
        int m = Integer.parseInt(st.nextToken()); // 선수 조건의 수
        indegree = new int[n + 1];
        result = new int[n + 1];

        // 단방향 2차원 리스트 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 단방향 2차원 리스트 설정
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int aSubject = Integer.parseInt(st.nextToken());
            int bSubject = Integer.parseInt(st.nextToken());

            graph.get(aSubject).add(bSubject);
            indegree[bSubject]++; // 각 인덱스 번호 = 노드 번호이므로 진입차수를 하나씩 카운트
        }

        topologicalSort();
    }

    private static void topologicalSort() {
        Queue<Integer> queue = new LinkedList<>();

        // 1. 진입차수가 0인 노드 큐에 삽입
        for (int i = 1; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                result[i] = 1; // 진입차수 0 이라면 한 학기에 들을 수 있기 때문에 1로 셋팅
            }
        }

        // 큐가 빌 때 까지 아래와 같은 작업 반복
        // 1. poll() 이후 해당 노드에서 출발하는 간선 제거
        // 2. 새롭게 진입차수가 0 이 된 노드 큐에 삽입
        while (!queue.isEmpty()) {
            int nowNode = queue.poll();

            for (int nextNode : graph.get(nowNode)) {
                indegree[nextNode]--; // 간선 제거

                if (indegree[nextNode] == 0) { // 확인 후 진입차수가 0 이라면 큐에 삽입
                    queue.offer(nextNode);
                    result[nextNode] = result[nowNode] + 1;
                }
            }
        }

        for (int i = 1; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}

// 순서가 정해져있는 작업을 차례로 수행해야할 때 그 순서를 결정하기 위해 사용하는 알고리즘
// 사이클이 발생하지 않는 방향 그래프일 떄 사용할 수 있다.
