package baekjoongold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 선수과목 {

    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 과목의 수 N (1 <= N <= 1,000)
        // 선수 조건의 수 M (0 <= M <= 500,000)
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Integer>> array = new ArrayList<>(); // 2차원 인접리스트
        int[] indegree = new int[n + 1]; // 해당 노드를 가리키는 진입 차수를 저장하는 배열
        result = new int[n + 1]; // 갱신을 위한 배열

        // 2차원 인접리스트 생성을 위해 초기화
        for (int i = 0; i <= n; i++) {
            array.add(new ArrayList<>());
        }

        // 2차원 인접리스트 생성 및 진입 차수 저장 배열 셋팅
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            array.get(a).add(b);
            indegree[b]++;
        }

        topologicalSort(indegree, array);

        for (int i = 1; i <= n; i++) {
            System.out.print(result[i] + " ");
        }
    }

    private static void topologicalSort(int[] indegree, List<List<Integer>> array) {
        Queue<Integer> queue = new LinkedList<>(); // 진입 차수가 0이 된 노드들을 담기 위한 큐

        // queue 에 진입차수가 0 인 노드를 담는다.
        for (int i = 1; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                result[i] = 1; // 진입차수가 0이라면 한 학기에 들을 수 있는 과목이므로 1로 셋팅
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int nextNode : array.get(node)) {
                indegree[nextNode]--;

                if (indegree[nextNode] == 0) {
                    queue.offer(nextNode);
                    result[nextNode] = result[node] + 1; // 이전 과목을 완료하기 위한 학기 수에서 +1 한 값으로 셋팅
                }
            }
        }
    }
}

/**
 1. 한 학기에 들을 수 있는 과목 수에는 제한이 없다.
 2. 모든 과목은 매 학기 항상 개설된다.
 1번 과목부터 N 번 과목까지 차례대로 최소 몇 학기에 이수할 수 있는지를 한 줄에 공백으로 구분해 출력한다.
 위상 정렬의 경우 진행 중 진입 차수가 0인 정점이 없다면 사용할 수 없는데, 선수 과목 조건 중 A < B 라는 조건이 있기에 위상정렬을 사용할 수 있다.
 */

/**
 * a b
 * 2 3 -> 2번 과목이 3번 과목의 선수과목
 * 1 2 -> 1번 과목이 2번 과목의 선수과목
 */