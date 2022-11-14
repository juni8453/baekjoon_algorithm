package this_is_coding_test.various_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class City implements Comparable<City> {
    int a, b, cost;

    public City(int a, int b, int cost) {
        this.a = a;
        this.b = b;
        this.cost = cost;
    }

    // 간선 비용 오름차순 정렬
    @Override
    public int compareTo(City o) {
        return this.cost - o.cost;
    }
}

public class 도시_분할_계획 {

    static int answer = 0;
    static int[] unf;
    static List<City> cities;

    static int Find(int v) {
        if (v == unf[v]) {
            return unf[v];
        } else {
            return unf[v] = Find(unf[v]);
        }
    }

    static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);

        if (fa != fb) {
            unf[fb] = fa;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        cities = new ArrayList<>();
        unf = new int[node + 1];

        // 부모 배열을 확인하는 unf[] 배열 노드 + 1 개수로 초기화
        for (int i = 1; i < node + 1; i++) {
            unf[i] = i;
        }

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            cities.add(new City(a, b, cost));
        }

        // 크루스칼 알고리즘을 사용하기 위해 간선 비용 기준 오름차순으로 정렬 실시
        Collections.sort(cities);

        int highCostEdge = Integer.MIN_VALUE;

        for (City city : cities) {
            if (Find(city.a) != Find(city.b)) { // 만약 두 도시의 부모 값이 다르다면, (사이클이 아니라면)
                highCostEdge = Math.max(highCostEdge, city.cost);
                answer += city.cost;
                Union(city.a, city.b); // 도시를 연결한다.
            }
        }

        answer -= highCostEdge;

        System.out.println(answer);
    }
}

// 최소 신장 트리 문제 (크루스칼 알고리즘 사용)
// 두 개의 마을로 나누기 위해서 가장 먼저 최소 신장 트리를 만든 뒤, 최소 신장 트리를 구성하는 간선 중 가장 비용이 큰 간선 하나만 떼주면
// 두 개의 마을 즉, 두 개의 신장 트리로 나눌 수 있다.

/**
 7 12
 1 2 3
 1 3 2
 3 2 1
 2 5 2
 3 4 4
 7 3 6
 5 1 5
 1 6 2
 6 4 1
 6 5 3
 4 5 3
 6 7 4
 */