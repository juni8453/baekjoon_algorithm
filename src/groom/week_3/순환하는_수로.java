package groom.week_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 순환하는_수로 {

    static int nodeIdx;
    static int edge;
    static int answerTankIdx;
    static boolean[] checked;
    static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) throws IOException {
        graph = new ArrayList<>();
        for (int i = 0; i < nodeIdx + 1; i++) {
            graph.add(new ArrayList<>());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        nodeIdx = Integer.parseInt(br.readLine());
        checked = new boolean[nodeIdx + 1];

        for (int i = 0; i < edge; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            // 양방향 그래프 설정
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        dfs(1, 0);


    }

    private static void dfs(int startNode, int depth) {

    }
}

// 첫째 줄에는 순환하는 수로에 포함된 물탱크의 수를 출력해라.
// 둘째 줄에는 순환하는 수로를 찾아 해당 수로를 구성하는 물탱크의 번호를 공백으로 구분해 오름차순으로 출력해라.
// 첫 번째 테스트 케이스를 예로, 1번 물탱크부터 공급을 시작했을 때
// 1 -> 2 -> 4 -> 3 -> 4 -> 2 -> 5 -> 2 -> 1 순으로 물을 공급한다.
// 이 때 [2, 4, 3, 4, 2] 를 거치는 부분이 순환하는 수로이다.
// 물탱크가 최소 3개 이상이며 2번에서 공급을 시작해 다시 2번으로 돌아오기 때문이다.

// 순환하는 수로란, 다음 조건을 만족한다.
/**
 * 최초 하나의 물탱크를 선택하고 물을 채운 뒤, 물탱크에 연결된 다른 물탱크에 물을 공급한다.
 * 어떤 물탱크에 있던 물이 특정한 수로들을 거쳐 다시 원래의 물탱크로 돌아올 때, 그 수로들의 집합을 순환하는 수로라 한다.
 * 순환하는 수로의 물탱크 갯수는 최소 3개 이상이다.
 */

/**
 * 1 2
 * 2 4
 * 3 1
 * 4 3
 * 5 2
 */