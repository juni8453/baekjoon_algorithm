package study.section9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class City implements Comparable<City>{
    int aCity;
    int bCity;
    int money;

    public City(int aCity, int bCity, int money) {
        this.aCity = aCity;
        this.bCity = bCity;
        this.money = money;
    }

    // 간선정보(비용) 오름차순 정렬
    @Override
    public int compareTo(City o) {
        return this.money - o.money;
    }
}

public class Section0907 {
    static int[] unf;

    // 배열에서 소속된 집합을 찾아주는 메서드
    static int Find(int v) {
        if (v == unf[v]) {
            return unf[v];
        } else {
            return unf[v] = Find(unf[v]);
        }
    }

    // 합치는 메서드
    static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if (fa != fb) unf[fa] = fb;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int answer = 0;
        unf = new int[v + 1];
        List<City> cities = new ArrayList<>();

        // unf 배열 초기 설정
        for (int i = 1; i <= v; i++) {
            unf[i] = i;
        }

        // 간선, 비용 초기화
        for (int i = 0; i < e; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int aCity = Integer.parseInt(st2.nextToken());
            int bCity = Integer.parseInt(st2.nextToken());
            int money = Integer.parseInt(st2.nextToken());
            cities.add(new City(aCity, bCity, money));
        }

        Collections.sort(cities);

        // 크루스칼 알고리즘 실행
        for (City city : cities) {
            if (Find(city.aCity) != Find(city.bCity)) {
                answer += city.money;
                Union(city.aCity, city.bCity);
            }
        }

        System.out.println(answer);
    }
}

/* 최소 신장트리 알고리즘
* 1. 먼저 모든 간선정보를 오름차순으로 정렬한다. (가장 비용이 적은 간선부터 찾아내야 최소 유지비용이 나오니까)
* 2. 간선을 하나씩 확인하면서 사이클이 발생하는지 확인한다.
* 2-1. 사이클이 발생하지 않는 간선이면 신장트리에 포함시킨다. (Union 메서드로 합치기)
* 2-2. 사이클이 발생한다면 신장트리에 포함시키지 않는다.
* 3. 2번을 반복하며 끝이나면, 신장트리에 포함된 모든 간선 정보의 합을 더한다. (이게 최솟값이 될 것임)
* */
